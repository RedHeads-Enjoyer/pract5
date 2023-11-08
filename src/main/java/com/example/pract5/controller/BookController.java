package com.example.pract5.controller;

import com.example.pract5.entity.Book;
import com.example.pract5.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    BookService bookService;

    @PostMapping("/books")
    public int create(@RequestBody Book book) {
        bookService.save(book);
        return book.getId();
    }

    @GetMapping("/books")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/books/{id}")
    public Book getById(@PathVariable int id) {
        return bookService.getById(id);
    }

    @PutMapping("/books/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book){
        bookService.update(id, book);
        return book;
    }

    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable int id){
        bookService.delete(id);
    }

}
