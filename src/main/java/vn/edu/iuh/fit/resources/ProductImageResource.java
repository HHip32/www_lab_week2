package vn.edu.iuh.fit.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.ProductImage;
import vn.edu.iuh.fit.services.ProductImageService;

import java.util.List;
@Path("/product-images")
public class ProductImageResource {
    private final ProductImageService productImageService;

    public ProductImageResource() {
        productImageService = new ProductImageService();
    }
    @GET
    @Produces("application/json")
    public Response getAll(){
        List<ProductImage> productImages = productImageService.getAllProductImage();
        return Response.ok(productImages).build();
    }

}
