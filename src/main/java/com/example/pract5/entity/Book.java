package com.example.pract5.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public Type getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

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

    @Column
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Book(String title, int seller_id, float price, String author, int amount) {
        this.title = title;
        this.seller_id = seller_id;
        this.price = price;
        this.author = author;
        this.amount = amount;
    }

    public Book() {

    }

    public int getId() {
        return id;
    }
}
