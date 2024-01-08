package org.example.service;

import jakarta.annotation.PostConstruct;
import org.example.model.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WarehouseService {

    private final Map<Long, Item> warehouse = new HashMap<>();

    public Item getById(long id) {
        return warehouse.get(id);
    }

    @PostConstruct
    public void postContract() {
        List<String> items = List.of("Смартфон", "Ноутбук", "Принтер", "Монитор");
        for (int i = 0; i < items.size(); i++) {
            long id = i+1;
            Item item = new Item(id, items.get(i));
            warehouse.put(id, item);
        }
    }

}
