package com.example.pract5.controller;

import com.example.pract5.entity.*;
import com.example.pract5.exception.ResourceNotFoundException;
import com.example.pract5.repository.BookRepository;
import com.example.pract5.repository.TelephoneRepository;
import com.example.pract5.repository.WashingMachineRepository;
import com.example.pract5.service.BookService;
import com.example.pract5.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class CartController {
    @Autowired
    CartService cartService;

    @Autowired
    BookRepository bookRepository;
    @Autowired
    TelephoneRepository telephoneRepository;
    @Autowired
    WashingMachineRepository washingMachineRepository;


    @PostMapping ("/cart")
    public ModelAndView  create(@RequestParam("productId") int productId, @RequestParam("clientId") int clientId, @RequestParam("type")Type type, @RequestParam("title") String  title) {
        if (type == Type.Books) {
            Book book = bookRepository.findById(productId).orElseThrow();
            if (book.getAmount() != 0) {
                book.setAmount(book.getAmount() - 1);
                bookRepository.save(book);
                cartService.save(new Cart(type, productId, 1, clientId, title));
            }
        }

        else if (type == Type.Plumbing) {
            WashingMachine washingMachine = washingMachineRepository.findById(productId).orElseThrow();
            if (washingMachine.getAmount() != 0) {
                washingMachine.setAmount(washingMachine.getAmount() - 1);
                washingMachineRepository.save(washingMachine);
                cartService.save(new Cart(type, productId, 1, clientId, title));
            }
        }

        else if (type == Type.Electronics) {
            Telephone telephone = telephoneRepository.findById(productId).orElseThrow();
            if (telephone.getAmount() != 0) {
                telephone.setAmount(telephone.getAmount() - 1);
                telephoneRepository.save(telephone);
                cartService.save(new Cart(type, productId, 1, clientId, title));
            }
        }

        return new ModelAndView("redirect:" + "http://localhost:8080/");
    }


    @GetMapping("/cart")
    public List<Cart> getAll() {
        return cartService.getAll();
    }

    @PutMapping("/cart/{id}")
    public void increase(@PathVariable int id) throws ResourceNotFoundException {
        cartService.increase(id);
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) throws ResourceNotFoundException {
        return cartService.delete(id);
    }
}
