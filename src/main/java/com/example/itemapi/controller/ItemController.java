package com.example.itemapi.controller;

import com.example.itemapi.model.Item;
import com.example.itemapi.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // GET all items
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // GET item by id
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id) {
        Optional<Item> item = itemService.getItemById(id);
        return item.orElse(null);
    }

    // POST add item
    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    // PUT update item
    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item updatedItem) {
        return itemService.updateItem(id, updatedItem);
    }

    // DELETE item
    @DeleteMapping("/{id}")
    public boolean deleteItem(@PathVariable int id) {
        return itemService.deleteItem(id);
    }
}
