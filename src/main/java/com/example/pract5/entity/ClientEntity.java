package com.example.pract5.entity;

import com.example.pract5.entity.template.AbstractEntity;
import com.example.pract5.form.ClientForm;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class ClientEntity extends AbstractEntity<ClientForm> {

    private String name;

    private String email;

    private String login;

    private String password;


    @Override
    public void update(ClientForm form) {
        this.name = form.getName();
        this.email = form.getEmail();
        this.login = form.getLogin();
        this.password = form.getPassword();
    }
}
