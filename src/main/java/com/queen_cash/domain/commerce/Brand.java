package com.queen_cash.domain.commerce;

import com.queen_cash.domain.model.DomainBase;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Brand extends DomainBase {
    @NotNull
    private String name;

    @Size(max = 1000)
    private String description;
}
