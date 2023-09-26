package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.repositories.OrderRepository;

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
