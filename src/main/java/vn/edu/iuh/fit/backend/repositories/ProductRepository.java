package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.enums.ProductStatus;
import vn.edu.iuh.fit.backend.models.Product;

import java.util.List;

public class ProductRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public ProductRepository() {
        em = Persistence
                .createEntityManagerFactory("my-persistence")
                .createEntityManager();
        trans = em.getTransaction();
    }
    public List<Product> getAllProduct(){
        return em.createNamedQuery("Product.getAll", Product.class)
                .setParameter(1, ProductStatus.ACTIVE)
                .getResultList();
    }
    public void insert(Product product) {
        try {
            trans.begin();
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            logger.error(e.getMessage());
        }
    }

}
