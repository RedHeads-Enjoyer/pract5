package com.example.pract5.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String company;

    @Column
    private int batterySize;

    @Column
    private int seller_id;

    @Column
    private final Type type = Type.Electronics;

    @Column
    private float price;

    @Column
    private String title;

    @Column
    private int amount;

    public Telephone() {

    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
//    private Boolean isAdded;

    public Telephone(String company, int batterySize, int seller_id, float price, String title, int amount) {
        this.company = company;
        this.batterySize = batterySize;
        this.seller_id = seller_id;
        this.price = price;
        this.title = title;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }
}
