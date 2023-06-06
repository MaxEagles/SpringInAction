package com.maxeagles.spring;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;

@Data
@Table
public class Taco {

    @Id
    private Long id;

    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message = "Name >= 5 symbols")
    private String name;

    @NotNull
    @Size(min = 1, message = "Choose ingredients")
    private List<IngredientRef> ingredients;
}

