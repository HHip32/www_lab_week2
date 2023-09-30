package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.OrderDetail;
import vn.edu.iuh.fit.backend.repositories.OrderDetailRepository;

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
