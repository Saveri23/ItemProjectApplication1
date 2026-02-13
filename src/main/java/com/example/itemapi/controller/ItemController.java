package com.example.itemapi.controller;

import com.example.itemapi.dto.ApiResponse;
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
    public ApiResponse addItem(@RequestBody Item item) {
        Item savedItem = itemService.addItem(item);
        return new ApiResponse("Item added successfully", savedItem);
    }


    // PUT update item
    @PutMapping("/{id}")
    public ApiResponse updateItem(@PathVariable int id,
                                  @RequestBody Item updatedItem) {

        Item item = itemService.updateItem(id, updatedItem);

        if (item != null) {
            return new ApiResponse("Item updated successfully", item);
        } else {
            return new ApiResponse("Item not found", null);
        }
    }


    // DELETE item
    @DeleteMapping("/{id}")
    public ApiResponse deleteItem(@PathVariable int id) {

        boolean deleted = itemService.deleteItem(id);

        if (deleted) {
            return new ApiResponse("Item deleted successfully", null);
        } else {
            return new ApiResponse("Item not found", null);
        }
    }

}
