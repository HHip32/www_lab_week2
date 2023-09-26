package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.repositories.ProductRepository;

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
