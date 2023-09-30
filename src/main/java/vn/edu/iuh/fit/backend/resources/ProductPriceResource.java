package vn.edu.iuh.fit.backend.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.ProductPrice;
import vn.edu.iuh.fit.backend.services.ProductPriceService;

import java.util.List;

@Path("/product-prices")
public class ProductPriceResource {
    private final ProductPriceService productPriceService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductPriceResource() {
        productPriceService = new ProductPriceService();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        List<ProductPrice> productPrices = productPriceService.getAllProductPrice();
        return Response.ok(productPrices).build();
    }
}
