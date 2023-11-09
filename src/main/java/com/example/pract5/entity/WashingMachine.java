package com.example.pract5.entity;

import jakarta.persistence.*;

@Entity
@Table
public class WashingMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private final Type type = Type.Plumbing;

    @Column
    private String company;

    public WashingMachine() {

    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public float getTankSize() {
        return tankSize;
    }

    public void setTankSize(float tankSize) {
        this.tankSize = tankSize;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Column
    private float tankSize;

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    @Column
    private int seller_id;

    @Column
    private String title;

    @Column
    private float price;

    @Column
    private int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public WashingMachine(String company, float tankSize, int seller_id, String title, float price, int amount) {
        this.company = company;
        this.tankSize = tankSize;
        this.seller_id = seller_id;
        this.title = title;
        this.price = price;
        this.amount = amount;
    }
}
