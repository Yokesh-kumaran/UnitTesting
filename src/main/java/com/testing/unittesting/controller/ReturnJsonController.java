package com.testing.unittesting.controller;

import com.testing.unittesting.model.Item;
import com.testing.unittesting.service.ReturnJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReturnJsonController {
    @Autowired
    private ReturnJsonService returnJsonService;

    @GetMapping("/returnJson")
    public Item returnJson() {
        return new Item(1, "Love", 10, 20);
    }

    @GetMapping("/itemFromService")
    public Item itemFromService() {
        return returnJsonService.returnJson();
    }

    @GetMapping("/allDataFromService")
    public List<Item> getAllItems() {
        return returnJsonService.retreiveAllData();
    }
}
