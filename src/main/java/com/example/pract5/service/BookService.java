package com.example.pract5.service;

import com.example.pract5.entity.Book;
import com.example.pract5.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookService  {

    BookRepository bookRepository;
    public List<Book> getAll() {
        List<Book> books = new ArrayList<Book>();
        bookRepository.findAll().forEach(book -> books.add(book));
        return books;
    }

    public Book getById(int id) {
        return bookRepository.findById(id).get();
    }
    public void save(Book book) {
        bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(int id, Book book) {
        bookRepository.deleteById(id);
        bookRepository.save(book);
    }
}
