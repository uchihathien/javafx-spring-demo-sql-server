package cinema.backend.service;

import cinema.backend.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> getAllOrders();
    Optional<Order> getOrderById(int id);
    Order saveOrder(Order order);
    void deleteOrder(int id);
    List<Order> getOrdersByUserId(int userId);

}
