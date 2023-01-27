package by.tms.lesson48homework.controller;

import by.tms.lesson48homework.dao.OrderRepository;
import by.tms.lesson48homework.dao.PetRepository;
import by.tms.lesson48homework.entity.Order;
import by.tms.lesson48homework.status.PetStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/store")
@Tag(name = "store", description = "Access to Petstore orders")
public class StoreController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PetRepository petRepository;

    @Operation(summary = "Place an order for a pet")
    @PostMapping("/order")
    public ResponseEntity<Order> placeAnOrder(@Valid @RequestBody Order order) {
        Order save = orderRepository.save(order);
        return new ResponseEntity(save, HttpStatus.CREATED);
    }

    @Operation(summary = "Find purchase order by ID", description = "For valid response try integer IDs with value >= 1 " +
            "and <= 10. Other values will generated exceptions")
    @GetMapping("/order/{orderId}")
    public ResponseEntity<Order> findById(@PathVariable int orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            return ResponseEntity.ok(optionalOrder.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Returns pet inventories by status", description = "Returns a map of status codes to quantities")
    @GetMapping("/inventory")
    public ResponseEntity<Map<PetStatus, Integer>> inventoriesByStatus() {
        Map<PetStatus, Integer> map = new HashMap<>();
        map.put(PetStatus.AVAILABLE, petRepository.findAllByStatus(PetStatus.AVAILABLE).size());
        map.put(PetStatus.PENDING, petRepository.findAllByStatus(PetStatus.PENDING).size());
        map.put(PetStatus.SOLD, petRepository.findAllByStatus(PetStatus.SOLD).size());
        return ResponseEntity.ok(map);
    }

    @Operation(summary = "Delete purchase order by ID", description = "For valid response try integer IDs with positive " +
            "integer value. Negative or non-integer values will generate API errors")
    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<Order> deleteById(@PathVariable int orderId) {
        orderRepository.deleteById(orderId);
        return ResponseEntity.ok().build();
    }
}
