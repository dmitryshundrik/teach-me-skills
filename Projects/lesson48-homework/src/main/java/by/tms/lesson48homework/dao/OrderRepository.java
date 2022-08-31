package by.tms.lesson48homework.dao;

import by.tms.lesson48homework.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {


}
