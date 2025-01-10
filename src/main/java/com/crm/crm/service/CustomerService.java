package com.crm.crm.service;

import com.crm.crm.model.Customer;
import com.crm.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Retrieve all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Add a new customer
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    // Get a customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Update an existing customer
    public void updateCustomer(Customer customer) {
        if (customer.getId() != null && customerRepository.existsById(customer.getId())) {
            customerRepository.save(customer);
        } else {
            throw new IllegalArgumentException("Customer ID is invalid or does not exist.");
        }
    }

    // Delete a customer by ID
    public void deleteCustomer(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Customer ID is invalid or does not exist.");
        }
    }
}
