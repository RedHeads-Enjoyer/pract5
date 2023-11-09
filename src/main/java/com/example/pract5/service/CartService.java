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
import org.springframework.web.bind.annotation.RequestParam;

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
        List<Cart> carts = cartRepository.findAll();
        for (Cart c : carts) {
            if (c.getProduct_id() == cart.getProduct_id() && c.getType() == cart.getType()) {
                c.setProduct_amount(c.getProduct_amount() + 1);
                return cartRepository.save(c);
            }
        }
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
            if (book.getAmount() == 0) {
                return ResponseEntity.ok(cart);
            } else {
                book.setAmount(book.getAmount() - 1);
                bookRepository.save(book);
            }
        }

        if (cart.getType() == Type.Electronics) {
            Telephone telephone = telephoneRepository.findById(cart.getProduct_id()).orElseThrow();
            if (telephone.getAmount() == 0) {
                return ResponseEntity.ok(cart);
            } else {
                telephone.setAmount(telephone.getAmount() - 1);
                telephoneRepository.save(telephone);
            }
        }

        if (cart.getType() == Type.Plumbing) {
            WashingMachine washingMachine = washingMachineRepository.findById(cart.getProduct_id()).orElseThrow();
            if (washingMachine.getAmount() == 0) {
                return ResponseEntity.ok(cart);
            }else {
                washingMachine.setAmount(washingMachine.getAmount() - 1);
                washingMachineRepository.save(washingMachine);
            }
        }
        cart.setProduct_amount(cart.getProduct_amount() + 1);
        Cart updatedCart = cartRepository.save(cart);
        return ResponseEntity.ok(updatedCart);
    }

    public void decrease(@PathVariable int id) throws ResourceNotFoundException {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not exist with id :" + id));
        Type type = cart.getType();
        if (type == Type.Books) {
            Book book = bookRepository.findById(cart.getProduct_id()).orElseThrow();
            book.setAmount(book.getAmount() + 1);
            bookRepository.save(book);
        }
        else if (type == Type.Electronics) {
            Telephone telephone = telephoneRepository.findById(cart.getProduct_id()).orElseThrow();
            telephone.setAmount(telephone.getAmount() + 1);
            telephoneRepository.save(telephone);
        }
        else if (type == Type.Plumbing) {
            WashingMachine washingMachine = washingMachineRepository.findById(cart.getProduct_id()).orElseThrow();
            washingMachine.setAmount(washingMachine.getAmount() + 1);
            washingMachineRepository.save(washingMachine);
        }
        cart.setProduct_amount(cart.getProduct_amount() - 1);
        if (cart.getProduct_amount() == 0) {
            cartRepository.delete(cart);
        }
        else {
            cartRepository.save(cart);
        }
    }

    public void clear() {
        cartRepository.deleteAll();
    }


    public void create(@RequestParam("productId") int productId, @RequestParam("clientId") int clientId, @RequestParam("type")Type type, @RequestParam("title") String  title) {
        if (type == Type.Books) {
            Book book = bookRepository.findById(productId).orElseThrow();
            if (book.getAmount() != 0) {
                book.setAmount(book.getAmount() - 1);
                bookRepository.save(book);
                save(new Cart(type, productId, 1, clientId, title));
            }
        }

        else if (type == Type.Plumbing) {
            WashingMachine washingMachine = washingMachineRepository.findById(productId).orElseThrow();
            if (washingMachine.getAmount() != 0) {
                washingMachine.setAmount(washingMachine.getAmount() - 1);
                washingMachineRepository.save(washingMachine);
                save(new Cart(type, productId, 1, clientId, title));
            }
        }

        else if (type == Type.Electronics) {
            Telephone telephone = telephoneRepository.findById(productId).orElseThrow();
            if (telephone.getAmount() != 0) {
                telephone.setAmount(telephone.getAmount() - 1);
                telephoneRepository.save(telephone);
                save(new Cart(type, productId, 1, clientId, title));
            }
        }
    }
}
