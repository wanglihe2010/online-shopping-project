package com.example.order.controller;

import com.example.order.models.*;
import com.example.order.services.CustomerServiceProxy;
import com.example.order.services.ItemServiceProxy;
import com.example.order.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "order")
public class OrderController {
    private OrderService orderService;
    private CustomerServiceProxy customerServiceProxy;
    private ItemServiceProxy itemServiceProxy;

    public OrderController(OrderService orderService, CustomerServiceProxy customerServiceProxy, ItemServiceProxy itemServiceProxy) {
        this.orderService = orderService;
        this.customerServiceProxy = customerServiceProxy;
        this.itemServiceProxy = itemServiceProxy;
    }

    @PostMapping(value = "orders", produces = "application/json")
    public Long createOrder(@RequestBody InputOrder inputOrder) {
        // validate the customer
        Customer customer = this.customerServiceProxy.getCustomerByEmail(inputOrder.getEmail_id());
        System.out.println(customer);
        if(customer == null) {
            System.out.println("email not existed");
            return -1L;
        }

        // get the item qty
        Map<String, Long> item_counts =
                inputOrder.getItemNames().stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // validate the item
        for (Map.Entry<String,Long> entry : item_counts.entrySet()) {
            String item_name = entry.getKey();
            Long item_qty = entry.getValue();
            Item item = this.itemServiceProxy.getItemByName(item_name);
            if (item == null) {
                System.out.println("item not existed");
                return -1L;
            } else {
                inputOrder.setPrice(inputOrder.getPrice() + item_qty.intValue() * item.getPrice());
            }
        }

        // save the sale order
        Sales_order sales_order = new Sales_order();
        sales_order.setDate(inputOrder.getDate());
        sales_order.setDescription(inputOrder.getDescription());
        sales_order.setEmailId(inputOrder.getEmail_id());
        sales_order.setPrice(inputOrder.getPrice());
        Long orderId = this.orderService.addSalesOrder(sales_order).getId();

        // save the order item line
        for (Map.Entry<String,Long> entry : item_counts.entrySet()) {
            String item_name = entry.getKey();
            int item_qty = entry.getValue().intValue();
            Order_line_item order_line_item = new Order_line_item();
            order_line_item.setItem_name(item_name);
            order_line_item.setQuantity(item_qty);
            order_line_item.setOrderId(orderId);
            this.orderService.addOrderLineItem(order_line_item);
        }
        return orderId;
    }

    @GetMapping(value = "orders/{emailId}", produces = "application/json")
    public List<InputOrder> getOrderById(@PathVariable("emailId") String emailId) {
        List<Sales_order> sales_orders = this.orderService.getSaleOrderByEmailId(emailId);
        return sales_orders.stream().map(sales_order -> {
            List<Order_line_item> items= this.orderService.getOrderLineItemsByOrderId(sales_order.getId());
            List<String> itemNames = new ArrayList<>();
            items.forEach(item -> {
                for (int i = 0; i < item.getQuantity(); i++) {
                    itemNames.add(item.getItem_name());
                }
            });
            InputOrder inputOrder = new InputOrder();
            inputOrder.setDate(sales_order.getDate());
            inputOrder.setDescription(sales_order.getDescription());
            inputOrder.setEmail_id(sales_order.getEmailId());
            inputOrder.setItemNames(itemNames);
            inputOrder.setPrice(sales_order.getPrice());
            System.out.println(inputOrder);
            return inputOrder;
        }).collect(Collectors.toList());
    }
}
