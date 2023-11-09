package com.example.pract5.controller;

import com.example.pract5.entity.Book;
import com.example.pract5.entity.Cart;
import com.example.pract5.entity.Telephone;
import com.example.pract5.entity.WashingMachine;
import com.example.pract5.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class ViewController {
    @Autowired
    CartService cartService;

    @Autowired
    TelephoneService telephoneService;

    @Autowired
    WashingMachineService washingMachineService;

    @Autowired
    BookService bookService;

    @Autowired
    ClientService clientService;

    @GetMapping("")
    public String dosd(Model model) {
        List<Cart> carts = cartService.getAll();
        List<Telephone> telephones = telephoneService.getAll();
        List<WashingMachine> washingMachines = washingMachineService.getAll();
        List<Book> books = bookService.getAll();

        model.addAttribute("books", books);
        model.addAttribute("cart", carts);
        model.addAttribute("telephones", telephones);
        model.addAttribute("washing", washingMachines);
        return "index";
    }
}
