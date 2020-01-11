package com.example.customer.controller;

import com.example.customer.models.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
        System.out.println(new Date());
        return this.customerService.getAll();
    }

    @PostMapping(value = "addCustomer", produces = "application/json")
    public Customer addCustomer(@RequestBody  Customer customer) {
        return this.customerService.add(customer);
    }

    @GetMapping(value = "customers/{email}", produces = "application/json")
    public Customer getCustomerByEmail(@PathVariable("email") String email) {
        return this.customerService.getCustomerByEmail(email);
    }
}
