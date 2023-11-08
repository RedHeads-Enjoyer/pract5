package com.example.pract5.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String email;

//    @OneToMany(mappedBy = "client")
//    private List<Cart> cartList;

    public Client(String name, String login, String password, String email) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public int getId() {
        return id;
    }
}
