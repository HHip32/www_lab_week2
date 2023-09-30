package vn.edu.iuh.fit.backend.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.services.OrderService;

import java.util.List;

@Path("/orders")
public class OrderResource {
    private final OrderService orderService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public OrderResource() {
        orderService = new OrderService();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Order> orders = orderService.getAllOrder();
        return Response.ok(orders).build();
    }
}
