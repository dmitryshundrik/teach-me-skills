package by.tms.lesson48homework.controller;

import by.tms.lesson48homework.dao.InMemoryOrderDao;
import by.tms.lesson48homework.entity.Order;
import by.tms.lesson48homework.status.PetStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/store")
@Tag(name = "store", description = "Access to Petstore orders")
public class StoreController {

    @Autowired
    private InMemoryOrderDao orderDao;

    @Operation(summary = "Place an order for a pet")
    @PostMapping("/order")
    public ResponseEntity<Order> placeAnOrder(@Valid @RequestBody Order order) {
        Optional<Order> optionalOrder = orderDao.placeAnOrder(order);
        if (optionalOrder.isPresent()) {
            return ResponseEntity.ok(optionalOrder.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Find purchase order by ID", description = "For valid response try integer IDs with value >= 1 " +
            "and <= 10. Other values will generated exceptions")
    @GetMapping("/order/{orderId}")
    public ResponseEntity<Order> findById(@PathVariable int orderId) {
        Optional<Order> optionalOrder = orderDao.findById(orderId);
        if (optionalOrder.isPresent()) {
            return ResponseEntity.ok(optionalOrder.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Delete purchase order by ID", description = "For valid response try integer IDs with positive " +
            "integer value. Negative or non-integer values will generate API errors")
    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<Order> deleteById(@PathVariable int orderId) {
        Optional<Order> optionalOrder = orderDao.deleteById(orderId);
        if (optionalOrder.isPresent()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Returns pet inventories by status", description = "Returns a map of status codes to quantities")
    @GetMapping("/inventory")
    public ResponseEntity<Map<PetStatus, Integer>> inventoriesByStatus() {
        Optional<Map<PetStatus, Integer>> optionalOrder = orderDao.inventoriesByStatus();
        return ResponseEntity.ok(optionalOrder.get());
    }
}
