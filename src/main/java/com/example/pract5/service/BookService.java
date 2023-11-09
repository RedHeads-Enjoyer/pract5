package com.example.pract5.service;

import com.example.pract5.entity.Book;
import com.example.pract5.exception.ResourceNotFoundException;
import com.example.pract5.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BookService  {
    @Autowired
    BookRepository bookRepository;
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public ResponseEntity<Book> getById(@PathVariable int id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not exist with id :" + id));
        return ResponseEntity.ok(book);
    }
    public Book save(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable int id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not exist with id :" + id));

        bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    public ResponseEntity<Book> update(@PathVariable int id, @RequestBody Book newBook) throws ResourceNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not exist with id :" + id));

        book.setAmount(newBook.getAmount());
        book.setAuthor(newBook.getAuthor());
        book.setPrice(newBook.getPrice());
        book.setSeller_id(newBook.getSeller_id());
        book.setTitle(newBook.getTitle());
        Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }
}
