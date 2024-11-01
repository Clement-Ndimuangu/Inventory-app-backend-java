package com.example.inventory_app.cart;

public interface CartServices {
    Boolean addToCart(Long id);

    Cart getCart(Long id);

    Cart removeItem(Long id);
}
