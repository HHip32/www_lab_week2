package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.Customer;

import java.util.List;

public class CustomerRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CustomerRepository() {
        em = Persistence.createEntityManagerFactory("my-persistence").createEntityManager();
        trans = em.getTransaction();
    }
    public void insertCustomer(Customer customer){
        try {
            trans.begin();
            em.persist(customer);
            trans.commit();
        }catch (Exception e){
            trans.rollback();
            logger.error(e.getMessage());
        }
    }
    public List<Customer> getAllCustomer(){
        return em.createNamedQuery("Customer.getAll", Customer.class).getResultList();
    }
}
