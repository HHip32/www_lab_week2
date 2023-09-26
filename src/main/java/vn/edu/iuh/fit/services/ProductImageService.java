package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.ProductImage;
import vn.edu.iuh.fit.repositories.ProductImageRepository;

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
