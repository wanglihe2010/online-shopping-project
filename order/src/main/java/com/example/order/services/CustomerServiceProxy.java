package com.example.order.services;

import com.example.order.models.Customer;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service")
//@RibbonClient(name = "customer-service")
public interface CustomerServiceProxy {
    @GetMapping("api/customer/customers/{emailId}")
    Customer getCustomerByEmail(@PathVariable("emailId") String emailId);
}
