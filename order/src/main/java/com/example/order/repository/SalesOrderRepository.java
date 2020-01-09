package com.example.order.repository;

import com.example.order.models.Sales_order;
import org.springframework.data.repository.CrudRepository;

public interface SalesOrderRepository extends CrudRepository<Sales_order, Long> {
    Sales_order getSales_orderByEmailId(String email_id);
}
