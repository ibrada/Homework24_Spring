package org.example.controller;

import org.example.model.Item;
import org.example.service.StoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/get")
    public List<Item> get() {
        return storeService.get();
    }

    @GetMapping("/add")
    public void add(@RequestParam("id") List<Long> id) {
        storeService.add(id);
    }
}
