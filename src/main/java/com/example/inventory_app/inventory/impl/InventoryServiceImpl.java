package com.example.inventory_app.inventory.impl;

import com.example.inventory_app.inventory.InventoryRepository;
import com.example.inventory_app.inventory.InventoryService;
import com.example.inventory_app.inventory.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Item createItem(Item item) {
        return inventoryRepository.save(item);
    }

    @Override
    public List<Item> findAllItems(String search) {
        if(search != null){
            return inventoryRepository.findAllByNameIgnoreCaseContaining(search);
        }else {
            return inventoryRepository.findAll();
        }
    }

    @Override
    public Item findById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public Item DeleteById(Long id) {
        Item item = findById(id);
        inventoryRepository.deleteById(id);
        return item;
    }

    @Override
    public List<Item> findItemsWithSamePrice(int price) {
        return inventoryRepository.findAllByPrice(price);
    }

    @Override
    public Item updateItem(Long id, Item item) {
        Item itemToUpdate = inventoryRepository.findById(id).orElse(null);
        if(itemToUpdate != null){
            itemToUpdate.setName(item.getName());
            itemToUpdate.setImage(item.getImage());
            itemToUpdate.setCart(item.getCart());
            itemToUpdate.setPrice(item.getPrice());
            itemToUpdate.setDescription(item.getDescription());
            return inventoryRepository.save(itemToUpdate);
        }
        return item;
    }
}
