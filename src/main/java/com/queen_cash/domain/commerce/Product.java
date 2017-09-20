package com.queen_cash.domain.commerce;

import com.queen_cash.model.DomainBase;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Product extends DomainBase {
    @NotNull
    private String name;
    private String description = "";

    private Boolean isOnSale = false;
    private Boolean active = true;
    private Boolean isInTrash = false;
    private Boolean enableStock = true;

    @NotNull
    private Double basePrice = 0.0;
    @NotNull
    private Double salePrice = 0.0;
    @NotNull
    private Double costPrice = 0.0;
    @NotNull
    private Long stockQuantity = 0L;

    private String size;
    private String color;
    private String weight;
    private String weightUnit;
}