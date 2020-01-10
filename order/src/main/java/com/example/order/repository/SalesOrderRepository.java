package com.example.order.repository;

import com.example.order.models.Sales_order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalesOrderRepository extends CrudRepository<Sales_order, Long> {
    List<Sales_order> getSales_ordersByEmailId(String emailId);
}
