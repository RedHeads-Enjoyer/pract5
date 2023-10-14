package com.example.pract5.form.template;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractProductForm{
    @NotNull(message = "Поле id_seller не может быть пустым")
    private Long id_seller;

    @NotNull(message = "Поле price не может быть пустым")
    private Integer price;

    @NotNull(message = "Поле price не может быть пустым")
    private String title;
}
