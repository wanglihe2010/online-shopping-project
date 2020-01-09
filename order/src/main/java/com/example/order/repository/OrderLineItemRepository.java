package com.example.order.repository;

import com.example.order.models.Order_line_item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderLineItemRepository extends CrudRepository<Order_line_item, Long> {
    List<Order_line_item> getOrder_line_itemsByOrderId(Long order_id);
}
