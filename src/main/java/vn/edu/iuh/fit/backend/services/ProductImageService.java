package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.ProductImage;
import vn.edu.iuh.fit.backend.repositories.ProductImageRepository;

import java.util.List;

public class ProductImageService {
    private ProductImageRepository productImageRepository;

    public ProductImageService() {
        productImageRepository = new ProductImageRepository();
    }
    public List<ProductImage> getAllProductImage(){
        return productImageRepository.getAllProductImage();
    }
}
