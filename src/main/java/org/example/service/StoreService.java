package org.example.service;

import org.example.component.Basket;
import org.example.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StoreService {

    private final Basket basket;
    private final WarehouseService warehouseService;

    public StoreService(Basket basket, WarehouseService warehouseService) {
        this.basket = basket;
        this.warehouseService = warehouseService;
    }

    public void add(List<Long> ids) {
        basket.add(ids);
    }

    public List<Item> get() {
        return basket.getIds().stream()
                .map(warehouseService::getById)
                .collect(Collectors.toList());
    }

}
