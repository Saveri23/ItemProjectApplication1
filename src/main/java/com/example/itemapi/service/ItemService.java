package com.example.itemapi.service;

import com.example.itemapi.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final List<Item> items = new ArrayList<>();

    public ItemService() {
        items.add(new Item(1, "Apple", 50.0));
        items.add(new Item(2, "Banana", 20.0));
        items.add(new Item(3, "Mango", 100.0));
    }

    public List<Item> getAllItems() {
        return items;
    }

    public Optional<Item> getItemById(int id) {
        return items.stream().filter(i -> i.getId() == id).findFirst();
    }

    public Item addItem(Item item) {
        items.add(item);
        return item;
    }
}
