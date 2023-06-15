package com.maxeagles.spring;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message = "Name >= 5 symbols")
    private String name;

    @Size(min = 1, message = "Choose ingredients")
    @ManyToMany()
    private List<Ingredient> ingredients;

    private void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}

