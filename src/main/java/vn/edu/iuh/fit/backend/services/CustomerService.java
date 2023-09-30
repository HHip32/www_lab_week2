package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.repositories.CustomerRepository;

import java.util.List;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService() {
        customerRepository = new CustomerRepository();
    }
    public void insertCustomer(Customer customer){
        customerRepository.insertCustomer(customer);
    }
    public List<Customer> getAllCustomer(){
        return customerRepository.getAllCustomer();
    }
}
