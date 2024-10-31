package com.example.inventory_app.cart;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    private CartServices cartServices;

    public CartController(CartServices cartServices) {
        this.cartServices = cartServices;
    }

    @PutMapping("/{id}")
    public Boolean addToCart(@PathVariable Long id){
        return cartServices.addToCart(id);
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable Long id){
        return cartServices.getCart(id);
    }
}