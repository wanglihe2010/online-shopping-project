package com.example.order.services;

import com.example.order.models.Customer;
import com.example.order.models.Item;
import org.springframework.stereotype.Component;

@Component
public class FeignHystrixFallback implements CustomerServiceProxy, ItemServiceProxy {
    @Override
    public Customer getCustomerByEmail(String emailId){
        return null;
    }

    @Override
    public Item getItemByName(String name) {
        return null;
    }
}