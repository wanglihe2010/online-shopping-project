package com.example.customer.service;

import com.example.customer.models.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer add(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public List<Customer> getAll() {
        return (List<Customer>) this.customerRepository.findAll();
    }

    public Customer getCustomerByEmail(String email) {
        return this.customerRepository.findCustomerByEmail(email);
    }
}
