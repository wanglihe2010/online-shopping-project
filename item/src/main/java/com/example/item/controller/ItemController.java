package com.example.item.controller;

import com.example.item.models.Item;
import com.example.item.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "item")
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
    @Autowired
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @GetMapping(value = "items", produces = "application/json")
    public List<Item> getAllItems() {
        return this.itemService.getAllItems();
    }


    @PostMapping(value = "addItem", produces = "application/json")
    public Item addItem(@RequestBody Item item) {
        return this.itemService.addItem(item);
    }

    @Cacheable(value = "items", key = "#name")
    @GetMapping(value = "items/{name}", produces = "application/json")
    public Item getItem(@PathVariable("name") String name) {
        logger.info("getItem: " + name);
        return this.itemService.getItem(name);
    }
}
