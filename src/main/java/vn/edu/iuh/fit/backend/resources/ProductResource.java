package vn.edu.iuh.fit.backend.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.services.ProductService;

import java.util.List;

@Path("/products")
public class ProductResource {
    private final ProductService productService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductResource() {
        productService = new ProductService();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Product> products = productService.getAllProduct();
        return Response.ok(products).build();
    }
}
