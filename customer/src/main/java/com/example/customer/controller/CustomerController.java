package com.example.customer.controller;

import com.example.customer.models.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "customers", produces = "application/json")
    public List<Customer> getALL() {
        return this.customerService.getAll();
    }

    @PostMapping(value = "addCustomer", produces = "application/json")
    public Customer addCustomer(@RequestBody  Customer customer) {
        return this.customerService.add(customer);
    }
}
