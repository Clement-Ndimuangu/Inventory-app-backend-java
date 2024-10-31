package com.example.inventory_app.inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryService {

    Item createItem(Item item);

    List<Item> findAllItems(String search);

    Item findById(Long id);

    Item DeleteById(Long id);

    List<Item> findItemsWithSamePrice(int price);

    Item updateItem(Long id, Item item);
}
