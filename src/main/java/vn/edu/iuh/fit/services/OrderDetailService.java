package vn.edu.iuh.fit.services;

import jakarta.ws.rs.Path;
import vn.edu.iuh.fit.models.OrderDetail;
import vn.edu.iuh.fit.repositories.OrderDetailRepository;

import java.util.List;

public class OrderDetailService {
    private OrderDetailRepository orderDetailRepository;

    public OrderDetailService() {
        orderDetailRepository = new OrderDetailRepository();
    }
    public List<OrderDetail> getAllOrderDetail(){
        return orderDetailRepository.getAllOrderDetail();
    }
}
