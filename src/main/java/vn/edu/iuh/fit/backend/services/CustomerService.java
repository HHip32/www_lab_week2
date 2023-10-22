package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Customer;
import vn.edu.iuh.fit.backend.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService() {
        customerRepository = new CustomerRepository();
    }

    public void insertCustomer(Customer customer) {
        customerRepository.insertCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    public boolean deleteCustomer(long id) {
        return customerRepository.deleteCustomer(id);
    }

    public Optional<Customer> findCustomer(long id) {
        return customerRepository.findCustomer(id);
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }
}
