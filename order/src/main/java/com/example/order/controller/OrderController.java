package com.example.order.controller;

import com.example.order.models.Customer;
import com.example.order.models.InputOrder;
import com.example.order.models.Item;
import com.example.order.models.Sales_order;
import com.example.order.services.CustomerServiceProxy;
import com.example.order.services.ItemServiceProxy;
import com.example.order.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//        Customer customer = this.customerServiceProxy.getCustomerByEmail(inputOrder.getEmail_id());
//        if(customer == null) return -1L;
//        Map<String, Long> item_counts =
//                inputOrder.getItemNames().stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
//        for (Map.Entry<String,Long> entry : item_counts.entrySet()) {
//            String item_name = entry.getKey();
//            Long item_qty = entry.getValue();
//            Item item = this.itemServiceProxy.getItemByName(item_name);
//            if (item == null) {
//                System.out.println("item not existed");
//                return -1L;
//            } else {
//                inputOrder.setPrice(inputOrder.getPrice() + item_qty.intValue() * item.getPrice());
//            }
//        }
//        Sales_order sales_order = new Sales_order();
//        sales_order.setDate(inputOrder.getDate());
//        sales_order.setDescription(inputOrder.getDescription());
//        sales_order.setEmailId(inputOrder.getEmail_id());
//        sales_order.setPrice(inputOrder.getPrice());
        return -1L;
    }

    @GetMapping(value = "items/{name}", produces = "application/json")
    public Item getItem(@PathVariable("name") String name) {
        System.out.println(name);
        Item item = this.itemServiceProxy.getItemByName(name);
        System.out.println(item);
        return item;
    }

    @GetMapping(value = "customers/{email}", produces = "application/json")
    public Customer getCustomer(@PathVariable("email") String emailId) {
        Customer customer = this.customerServiceProxy.getCustomerByEmail(emailId);
        return customer;
    }
}
