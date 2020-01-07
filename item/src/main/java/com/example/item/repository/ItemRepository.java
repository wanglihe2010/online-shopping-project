package com.example.item.repository;

import com.example.item.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
    Item findItemByName(String name);
}
