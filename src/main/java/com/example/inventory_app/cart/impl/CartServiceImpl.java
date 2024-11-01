package com.example.inventory_app.cart.impl;

import com.example.inventory_app.cart.Cart;
import com.example.inventory_app.cart.CartRepository;
import com.example.inventory_app.cart.CartServices;
import com.example.inventory_app.inventory.InventoryRepository;
import com.example.inventory_app.inventory.Item;
import org.springframework.stereotype.Service;


@Service
public class CartServiceImpl implements CartServices {

    private CartRepository cartRepository;
    private InventoryRepository inventoryRepository;

    public CartServiceImpl(CartRepository cartRepository, InventoryRepository inventoryRepository) {
        this.cartRepository = cartRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Boolean addToCart(Long id) {
        Cart cart = cartRepository.findById(1L).orElse(null);
        if(cart == null){
            Cart cart1 = new Cart();
            cart = cartRepository.save(cart1);
        }
        Item item = inventoryRepository.findById(id).orElse(null);
        if(item != null){
            item.setCart(cart);
            inventoryRepository.save(item);
            return  true;
        }
        return false;
    }

    @Override
    public Cart getCart(Long id) {
        Cart cart = cartRepository.findById(id).orElse(null);
        if(cart == null){
            Cart newCart = new Cart();
            return cartRepository.save(newCart);
        }
        return cart;
    }

    @Override
    public Cart removeItem(Long id) {
        Item item = inventoryRepository.findById(id).orElse(null);
        if(item != null){
            item.setCart(null);
            inventoryRepository.save(item);
            return cartRepository.findById(1L).orElse(null);
        }
        return null;
    }
}
