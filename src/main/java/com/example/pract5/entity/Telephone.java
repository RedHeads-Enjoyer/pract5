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

//    @Column
//    private Boolean isAdded;

    public Telephone(String company, int batterySize, int seller_id, float price, String title) {
        this.company = company;
        this.batterySize = batterySize;
        this.seller_id = seller_id;
        this.price = price;
        this.title = title;
//        this.isAdded = false;
    }

    public int getId() {
        return id;
    }
}
