package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private EmployeeRepository repository;

    public EmployeeService() {
        repository = new EmployeeRepository();
    }

    public void insertEmp(Employee employee) {
        repository.insertEmp(employee);
    }

    public void updateEmp(Employee employee) {
        repository.update(employee);
    }

    public Optional<Employee> findById(long id) {
        return repository.findbyId(id);
    }

    public boolean deleteEmp(long id) {
        return repository.delete(id);
    }

    public boolean activeEmp(long id) {
        Optional<Employee> op = findById(id);
        if (op.isPresent()) {
            Employee employee = op.get();
            employee.setStatus(EmployeeStatus.ACTIVE);
            return true;
        }
        return false;
    }

    public List<Employee> getAll() {
        return repository.getAllEmp();
    }


}
