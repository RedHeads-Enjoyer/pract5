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

    @PostMapping ("/cart")
    public ModelAndView  create(@RequestParam("productId") int productId, @RequestParam("clientId") int clientId, @RequestParam("type")Type type, @RequestParam("title") String  title) {
        cartService.create(productId, clientId,type, title);
        return new ModelAndView("redirect:" + "http://localhost/");
    }


    @GetMapping("/cart")
    public List<Cart> getAll() {
        return cartService.getAll();
    }

    @PostMapping("/cart/increase")
    public ModelAndView increase(@RequestParam("productId") int id) throws ResourceNotFoundException {
        cartService.increase(id);
        return new ModelAndView("redirect:" + "http://localhost/");
    }

    @PostMapping("/cart/decrease")
    public ModelAndView decrease(@RequestParam("productId") int id) throws ResourceNotFoundException {
        cartService.decrease(id);
        return new ModelAndView("redirect:" + "http://localhost/");
    }

    @PostMapping("/cart/clear")
    public ModelAndView clear() {
        cartService.clear();
        return new ModelAndView("redirect:" + "http://localhost/");
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) throws ResourceNotFoundException {
        return cartService.delete(id);
    }
}
