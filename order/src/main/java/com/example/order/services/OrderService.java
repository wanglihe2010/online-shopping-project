package com.example.order.services;

import com.example.order.models.Order_line_item;
import com.example.order.models.Sales_order;
import com.example.order.repository.OrderLineItemRepository;
import com.example.order.repository.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private SalesOrderRepository salesOrderRepository;
    private OrderLineItemRepository orderLineItemRepository;

    public OrderService(SalesOrderRepository salesOrderRepository, OrderLineItemRepository orderLineItemRepository) {
        this.salesOrderRepository = salesOrderRepository;
        this.orderLineItemRepository = orderLineItemRepository;
    }

    public Sales_order addSalesOrder(Sales_order sales_order) {
        return this.salesOrderRepository.save(sales_order);
    }

    public Order_line_item addOrderLineItem(Order_line_item order_line_item) {
        return this.orderLineItemRepository.save(order_line_item);
    }

    public Sales_order getSaleOrderByEmailId(String email_id) {
        return this.salesOrderRepository.getSales_orderByEmailId(email_id);
    }

    public List<Order_line_item> getOrderLineItemsByOrderId(Long order_id) {
        return this.orderLineItemRepository.getOrder_line_itemsByOrderId(order_id);
    }

}
