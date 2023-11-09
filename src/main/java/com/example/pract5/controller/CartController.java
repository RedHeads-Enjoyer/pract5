package com.example.pract5.controller;

import com.example.pract5.entity.Cart;
import com.example.pract5.exception.ResourceNotFoundException;
import com.example.pract5.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    CartService cartService;


    @PostMapping("/cart")
    public Cart create(@RequestBody Cart cart) {
        return cartService.save(cart);
    }


    @GetMapping("/cart")
    public List<Cart> getAll() {
        return cartService.getAll();
    }

    @PutMapping("/cart/{id}")
    public Cart update(@PathVariable int id, @RequestBody Cart cart) throws ResourceNotFoundException {
        cartService.update(id, cart);
        return cart;
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) throws ResourceNotFoundException {
        return cartService.delete(id);
    }
}
