package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.models.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction trans;
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeRepository() {
        em = Persistence
                .createEntityManagerFactory("my-persistence")
                .createEntityManager();
        trans = em.getTransaction();
    }

    public void insertEmp(Employee employee) {
        try {
            trans.begin();
            em.persist(employee);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }

    public void setStatus(Employee employee, EmployeeStatus status) {
        employee.setStatus(status);
    }

    public void update(Employee employee) {
        try {
            trans.begin();
            em.merge(employee);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
            logger.error(ex.getMessage());
        }
    }
    public boolean delete(long id){
        try{
            trans.begin();
            Optional<Employee> op = findbyId(id);
            if (op.isPresent()) {
                Employee employee = op.get();
                employee.setStatus(EmployeeStatus.TERMINATED);
                trans.commit();
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            trans.rollback();
        }
       return  false;
    }

    public Optional<Employee> findbyId(long id) {
        TypedQuery<Employee> query = em.createQuery("select e from Employee e where e.id=:id", Employee.class);
        query.setParameter("id", id);
        Employee emp = query.getSingleResult();
        return emp == null ? Optional.empty() : Optional.of(emp);
    }

    public List<Employee> getAllEmp() {
        return em.createNamedQuery("Employee.getAll", Employee.class)
                .setParameter(1, EmployeeStatus.ACTIVE)
                .getResultList();
    }

}
