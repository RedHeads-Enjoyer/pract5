package com.example.pract5.controller;

import com.example.pract5.entity.Book;
import com.example.pract5.exception.ResourceNotFoundException;
import com.example.pract5.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookService bookService;


    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        return bookService.save(book);
    }


    @GetMapping("/books")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getById(@PathVariable int id) throws ResourceNotFoundException {
        return bookService.getById(id);
    }

    @PutMapping("/books/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book) throws ResourceNotFoundException {
        bookService.update(id, book);
        return book;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) throws ResourceNotFoundException {
        return bookService.delete(id);
    }

}