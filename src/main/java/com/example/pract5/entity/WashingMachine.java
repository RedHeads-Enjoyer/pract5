package com.example.pract5.entity;

import jakarta.persistence.*;

@Entity
@Table
public class WashingMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private final Type type = Type.Electronics;

    @Column
    private String company;

    @Column
    private float tankSize;

    @Column
    private int seller_id;

    @Column
    private String title;

    @Column
    private float price;

//    @Column
//    private Boolean isAdded;

    public int getId() {
        return id;
    }

    public WashingMachine(String company, float tankSize, int seller_id, String title, float price) {
        this.company = company;
        this.tankSize = tankSize;
        this.seller_id = seller_id;
        this.title = title;
        this.price = price;
//        this.isAdded = false;
    }
}
