package com.example.order.services;

import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }
}
