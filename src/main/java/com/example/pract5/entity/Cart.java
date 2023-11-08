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
}
