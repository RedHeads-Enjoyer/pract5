package com.example.pract5.service;

import com.example.pract5.entity.Book;
import com.example.pract5.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService extends AbstractService<Book, BookRepository> {
    public BookService(BookRepository bookRepository) {
        super(bookRepository);
    }
}
