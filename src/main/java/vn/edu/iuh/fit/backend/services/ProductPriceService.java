package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.ProductPrice;
import vn.edu.iuh.fit.backend.repositories.ProductPriceRepository;

import java.util.List;

public class ProductPriceService {
    private ProductPriceRepository productPriceRepository;

    public ProductPriceService() {
        productPriceRepository = new ProductPriceRepository();
    }
    public List<ProductPrice> getAllProductPrice(){
        return productPriceRepository.getAllProductPrice();
    }
}
