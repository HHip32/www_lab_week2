package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.Order;

import java.util.List;

public class OrderRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public OrderRepository() {
        em = Persistence.createEntityManagerFactory("my-persistence").createEntityManager();
        trans = em.getTransaction();
    }

    public void insertOrder(Order order) {
        try {
            trans.begin();
            em.persist(order);
            trans.commit();
        } catch (Exception e) {
            trans.commit();
            logger.error(e.getMessage());
        }
    }

    public List<Order> getAllOrder() {
        return em.createNamedQuery("Order.getAll", Order.class).getResultList();
    }
}
