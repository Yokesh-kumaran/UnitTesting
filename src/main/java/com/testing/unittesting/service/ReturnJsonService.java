package com.testing.unittesting.service;

import com.testing.unittesting.data.ItemRepository;
import com.testing.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnJsonService {
    @Autowired
    private ItemRepository itemRepository;

    public Item returnJson() {
        return new Item(1, "Love", 10, 20);
    }

    public List<Item> retreiveAllData() {
        List<Item> items = itemRepository.findAll();
        for (Item item : items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }
}
