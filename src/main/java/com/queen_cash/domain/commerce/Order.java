package com.queen_cash.domain.commerce;

import com.queen_cash.domain.Customer;
import com.queen_cash.model.DomainBase;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "orders")
public class Order extends DomainBase {

    @OneToMany
    private Collection<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    private Customer customer;

    @NotNull
    @NotBlank
    private String customerName;
    @NotNull
    @NotBlank
    private String salesManName;
}
