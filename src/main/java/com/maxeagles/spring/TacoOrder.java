package com.maxeagles.spring;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt = new Date();

    @NotBlank(message = "required")
    private String deliveryName;

    @NotBlank(message = "required")
    private String deliveryStreet;

    @NotBlank(message = "required")
    private String deliveryCity;

    @NotBlank(message = "required")
    private String deliveryState;

    @NotBlank(message = "required")
    private String deliveryZip;

    @CreditCardNumber(message = "wrong credit card number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]1[0-2])([/])([2-9][0-9])$", message = "MM/YY format")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "wrong CVV")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();

    @ManyToOne
    private TacoUser user;

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
