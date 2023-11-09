package com.example.pract5.service;

import com.example.pract5.entity.*;
import com.example.pract5.exception.ResourceNotFoundException;
import com.example.pract5.repository.BookRepository;
import com.example.pract5.repository.CartRepository;
import com.example.pract5.repository.TelephoneRepository;
import com.example.pract5.repository.WashingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    BookRepository bookRepository;

    @Autowired
    TelephoneRepository telephoneRepository;

    @Autowired
    WashingMachineRepository washingMachineRepository;

    public List<Cart> getAll() {
        return cartRepository.findAll();
    }

    public Cart save(@RequestBody Cart cart) {
        return cartRepository.save(cart);
    }

    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not exist with id :" + id));

        cartRepository.delete(cart);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Cart> increase(@PathVariable int id) throws ResourceNotFoundException {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not exist with id :" + id));

        if (cart.getType() == Type.Books) {
            Book book = bookRepository.findById(cart.getProduct_id()).orElseThrow();
            if (book.getAmount() < cart.getProduct_amount() + 1) {
                return ResponseEntity.ok(cart);
            }
        }

        if (cart.getType() == Type.Electronics) {
            Telephone telephone = telephoneRepository.findById(cart.getProduct_id()).orElseThrow();
            if (telephone.getAmount() < cart.getProduct_amount() + 1) {
                return ResponseEntity.ok(cart);
            }
        }

        if (cart.getType() == Type.Plumbing) {
            WashingMachine washingMachine = washingMachineRepository.findById(cart.getProduct_id()).orElseThrow();
            if (washingMachine.getAmount() < cart.getProduct_amount() + 1) {
                return ResponseEntity.ok(cart);
            }
        }
        cart.setProduct_amount(cart.getProduct_amount() + 1);
        Cart updatedCart = cartRepository.save(cart);
        return ResponseEntity.ok(updatedCart);
    }

    public void decrease(@PathVariable int id) throws ResourceNotFoundException {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not exist with id :" + id));
        if (cart.getProduct_amount() == 1) {
            cartRepository.delete(cart);
        }
        else {
            Type type = cart.getType();
            if (type == Type.Books) {
                Book book = bookRepository.findById(cart.getProduct_id()).orElseThrow();
                bookRepository.delete(book);
                book.setAmount(book.getAmount() + 1);
                bookRepository.save(book);
            }
            else if (type == Type.Electronics) {
                Telephone telephone = telephoneRepository.findById(cart.getProduct_id()).orElseThrow();
                telephoneRepository.delete(telephone);
                telephone.setAmount(telephone.getAmount() + 1);
                telephoneRepository.save(telephone);
            }
            else if (type == Type.Plumbing) {
                WashingMachine washingMachine = washingMachineRepository.findById(cart.getProduct_id()).orElseThrow();
                washingMachineRepository.delete(washingMachine);
                washingMachine.setAmount(washingMachine.getAmount() + 1);
                washingMachineRepository.save(washingMachine);
            }
        }
    }

}
