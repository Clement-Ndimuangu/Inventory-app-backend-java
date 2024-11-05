package com.example.inventory_app.inventory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/api/items")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Item createItem(@RequestBody Item item){
        return inventoryService.createItem(item);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Item> getAllItems(@RequestParam(name = "search", required = false) String search){
        return inventoryService.findAllItems(search);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Item> getItemsWithSamePrice(@RequestParam int price){
        return inventoryService.findItemsWithSamePrice(price);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Item findById(@PathVariable Long id){
        return inventoryService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Item deleteById(@PathVariable Long id){
        return inventoryService.DeleteById(id);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item){
        return inventoryService.updateItem(id, item);
    }
}
