package com.example.inventory_app.inventory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByPrice(int price);
    List<Item> findAllByNameIgnoreCaseContaining(String name);
}
