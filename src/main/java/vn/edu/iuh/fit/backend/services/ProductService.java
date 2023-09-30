package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.repositories.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService() {
        productRepository = new ProductRepository();
    }
    public List<Product> getAllProduct(){
        return productRepository.getAllProduct();
    }
}
