package com.example.pract5.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ClientForm {

    @NotNull(message = "Поле name не может быть пустым")
    private String name;

    @NotNull(message = "Поле email не может быть пустым")
    @Email(message = "Это не email")
    private String email;

    @NotNull(message = "Поле login не может быть пустым")
    private String login;

    @NotNull(message = "Поле password не может быть пустым")
    private String password;
}
