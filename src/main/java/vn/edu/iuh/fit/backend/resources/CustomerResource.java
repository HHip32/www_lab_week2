package vn.edu.iuh.fit.backend.resources;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.services.CustomerService;

import java.util.List;

@Path("/customers")
public class CustomerResource {

    private final CustomerService customerService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CustomerResource() {
        customerService = new CustomerService();
    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Customer> customers = customerService.getAllCustomer();
        return Response.ok(customers).build();
    }
}
