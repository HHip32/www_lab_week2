package vn.edu.iuh.fit.resources;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@Path("/employees")
public class EmployeeResource {

    private final EmployeeService employeeService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeResource() {
        employeeService = new EmployeeService();
    }

    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Response getEmp(@PathParam("id") long eid) {
        Optional<Employee> empOpt = employeeService.findById(eid);
        if (empOpt.isPresent()) {
            return Response.ok(empOpt.get()).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

        @GET
    @Produces("application/json")
    public Response getAll() {
        //paging if possible
        List<Employee> lst = employeeService.getAll();
        return Response.ok(lst).build();
    }
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Employee employee) {
        //ResponseEntity
        employeeService.insertEmp(employee);
        return Response.ok(employee).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        if (employeeService.delete(id))
            return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
