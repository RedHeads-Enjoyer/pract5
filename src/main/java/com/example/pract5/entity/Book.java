package com.example.pract5.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private int seller_id;

    @Column
    private final Type type = Type.Books;

    @Column
    private float price;

    @Column
    private String author;
//    @Column
//    private Boolean isAdded;

    public Book(String title, int seller_id, float price, String author) {
        this.title = title;
        this.seller_id = seller_id;
        this.price = price;
        this.author = author;
//        this.isAdded = false;
    }

    public int getId() {
        return id;
    }
}
