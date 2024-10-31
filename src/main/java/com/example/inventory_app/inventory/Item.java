package com.example.inventory_app.inventory;

import com.example.inventory_app.cart.Cart;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 100000)
    private String description;
    private int price;
    private String category;
    @Column(length = 100000)
    private String image;
    @ManyToOne
    @JoinColumn(
            name = "cart_id"
    )
    @JsonBackReference
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
