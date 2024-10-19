package cinema.backend.service.impl;

import cinema.backend.entity.Order;
import cinema.backend.repo.OrderRepo;
import cinema.backend.service.OrderService;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private OrderRepo orderRepo;
    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Optional<Order> getOrderById(int id) {
        return orderRepo.findById(id);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public void deleteOrder(int id) {

    }

    @Override
    public List<Order> getOrdersByUserId(int userID) {
        return orderRepo.findByUserID(userID);
    }


}
