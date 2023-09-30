package vn.edu.iuh.fit.frontend.models;

import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.services.EmployeeService;

import java.util.List;
import java.util.Optional;

public class EmployeeModel {
    private final EmployeeService employeeService;

    public EmployeeModel() {
        employeeService = new EmployeeService();
    }

    public void insertEmployee(Employee employee) {
        employeeService.insertEmp(employee);
    }

    public Optional<Employee> getEmployee(long id) {

        return employeeService.findById(id);
    }
    public List<Employee> getEmployees(){
        return employeeService.getAll();
    }
}
