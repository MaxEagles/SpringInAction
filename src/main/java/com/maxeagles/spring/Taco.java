package com.maxeagles.spring;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

@Data
public class Taco {

    private Long id;

    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message = "Name >= 5 symbols")
    private String name;

    @NotNull
    @Size(min = 1, message = "Choose ingredients")
    private List<Ingredient> ingredients;
}

