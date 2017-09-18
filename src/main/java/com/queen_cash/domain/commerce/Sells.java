package com.queen_cash.domain.commerce;

import com.queen_cash.domain.Customer;
import com.queen_cash.domain.admin.Administrator;
import com.queen_cash.domain.model.DomainBase;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Sells extends DomainBase {

    @OneToMany
    private Collection<SellsItem> sellsItems = new ArrayList<>();
    @NotNull
    private Double salesTotal = 0.0;

    @OneToOne
    private Administrator salesMan;
    @OneToOne
    private Customer customer;

    @NotNull
    private String customerName;
    @NotNull
    private String salesManName;
}
