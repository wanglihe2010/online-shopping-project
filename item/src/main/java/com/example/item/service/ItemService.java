package com.example.item.service;

import com.example.item.models.Item;
import com.example.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return (List<Item>) this.itemRepository.findAll();
    }

    public Item getItem(String name) {
        return this.itemRepository.findItemByName(name);
    }

    public Item addItem(Item item) {
        return this.itemRepository.save(item);
    }
}
