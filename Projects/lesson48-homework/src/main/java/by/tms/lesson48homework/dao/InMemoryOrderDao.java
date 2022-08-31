package by.tms.lesson48homework.dao;

import by.tms.lesson48homework.entity.Order;
import by.tms.lesson48homework.status.PetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryOrderDao {

    @Autowired
    private InMemoryPetDao petDao;

    @Autowired
    private PetRepository petRepository;

    private final List<Order> orders = new ArrayList<>();
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public Optional<Order> placeAnOrder(Order order) {
        if (petDao.findById(order.getPet().getId()).isPresent()) {
            order.setId(atomicInteger.getAndIncrement());
            orders.add(order);
            return Optional.of(order);
        }
        return Optional.empty();
    }

    public Optional<Order> findById(int orderId) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    public Optional<Order> deleteById(int orderId) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == orderId) {
                Order order = orders.get(i);
                orders.remove(i);
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    public Optional<Map<PetStatus, Integer>> inventoriesByStatus() {
        Map<PetStatus, Integer> inventories = new HashMap<>();
//        inventories.put(PetStatus.AVAILABLE, petRepository.findAllByStatus(PetStatus.AVAILABLE).size());
//        inventories.put(PetStatus.PENDING, petRepository.findAllByStatus(PetStatus.PENDING).size());
//        inventories.put(PetStatus.SOLD, petRepository.findAllByStatus(PetStatus.SOLD).size());
        return Optional.of(inventories);
    }
}
