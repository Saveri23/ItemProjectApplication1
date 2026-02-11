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

    // GET /items
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // GET /items/{id}
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable int id) {
        Optional<Item> item = itemService.getItemById(id);
        return item.orElse(null);
    }

    // POST /items
    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }
    // PUT: update existing item
    public Item updateItem(int id, Item updatedItem) {
        for (Item i : items) {
            if (i.getId() == id) {
                i.setName(updatedItem.getName());
                i.setPrice(updatedItem.getPrice());
                return i;
            }
        }
        return null; // not found
    }

    // DELETE: remove item by id
    public boolean deleteItem(int id) {
        return items.removeIf(i -> i.getId() == id);
    }

}
