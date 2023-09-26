package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.models.Customer;
import vn.edu.iuh.fit.repositories.CustomerRepository;

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
