package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.ProductPrice;

import java.util.List;

public class ProductPriceRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductPriceRepository() {
        em = Persistence
                .createEntityManagerFactory("my-persistence")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public List<ProductPrice> getAllProductPrice(){
        return em.createNamedQuery("ProductPrice.getAll", ProductPrice.class).getResultList();
    }
}
