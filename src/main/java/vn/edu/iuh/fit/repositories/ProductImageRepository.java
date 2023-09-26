package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.ProductImage;

import java.util.List;

public class ProductImageRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductImageRepository() {
        em = Persistence
                .createEntityManagerFactory("my-persistence")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public List<ProductImage> getAllProductImage(){
        return em.createNamedQuery("ProductImage.getAll", ProductImage.class).getResultList();
    }
}
