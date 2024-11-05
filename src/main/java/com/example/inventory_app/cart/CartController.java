package com.example.inventory_app.cart;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
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

    @PutMapping("/removeitem/{id}")
    public Cart removeItem(@PathVariable Long id){
        return cartServices.removeItem(id);
    }
}
