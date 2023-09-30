package vn.edu.iuh.fit.backend.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.OrderDetail;
import vn.edu.iuh.fit.backend.services.OrderDetailService;

import java.util.List;


@Path("/order-details")
public class OrderDetailResource {

    private final OrderDetailService orderDetailService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public OrderDetailResource() {
        orderDetailService = new OrderDetailService();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        List<OrderDetail> orderDetails = orderDetailService.getAllOrderDetail();
        return Response.ok().build();
    }
}
