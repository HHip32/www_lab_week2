package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.repositories.OrderRepository;

import java.util.List;

public class OrderService {
    private OrderRepository orderRepository;

    public OrderService() {
        orderRepository = new OrderRepository();
    }
    public List<Order> getAllOrder(){
        return orderRepository.getAllOrder();
    }
}
