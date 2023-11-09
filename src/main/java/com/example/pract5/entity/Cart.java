package com.example.pract5.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Type type;

    @Column
    private int product_id;

    @Column
    private int product_amount;

    @Column
    private int client_id;

    @Column
    private String title;

    public Cart() {

    }

    public int getClient_id() {
        return client_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Cart(Type type, int product_id, int product_amount, int client_id, String title) {
        this.type = type;
        this.product_id = product_id;
        this.product_amount = product_amount;
        this.client_id = client_id;
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(int product_amount) {
        this.product_amount = product_amount;
    }
}
