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

    private final List<Order> orders = new ArrayList<>();
    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public Optional<Order> placeAnOrder(Order order) {
        if (petDao.findById(order.getPetId()).isPresent()) {
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
        inventories.put(PetStatus.AVAILABLE, petDao.findByStatus(PetStatus.AVAILABLE.name()).get().size());
        inventories.put(PetStatus.PENDING, petDao.findByStatus(PetStatus.PENDING.name()).get().size());
        inventories.put(PetStatus.SOLD, petDao.findByStatus(PetStatus.SOLD.name()).get().size());
        return Optional.of(inventories);
    }
}
