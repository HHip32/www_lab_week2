package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.models.Employee;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public CustomerRepository() {
        em = Persistence.createEntityManagerFactory("my-persistence").createEntityManager();
        trans = em.getTransaction();
    }

    public void insertCustomer(Customer customer) {
        try {
            trans.begin();
            em.persist(customer);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            logger.error(e.getMessage());
        }
    }
    public void updateCustomer(Customer customer){
        try {
            trans.begin();
            em.merge(customer);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            logger.error(e.getMessage());
        }
    }

    public boolean deleteCustomer(long id){
        try{
            trans.begin();
            em.remove(em.find(Customer.class,id));
            trans.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Optional<Customer> findCustomer(long id) {

        Customer customer = em.find(Customer.class, id);

        return customer == null ? Optional.empty() : Optional.of(customer);
    }

    public List<Customer> getAllCustomer() {
        return em.createNamedQuery("Customer.getAll", Customer.class).getResultList();
    }
}
