package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.ProductPrice;
import vn.edu.iuh.fit.repositories.ProductPriceRepository;

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
