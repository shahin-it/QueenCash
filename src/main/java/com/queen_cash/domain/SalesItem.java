package com.queen_cash.domain;

import com.queen_cash.domain.model.DomainBase;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class SalesItem extends DomainBase {
    @NotNull
    private Long productId;
    @NotNull
    private String productName;
    @NotNull
    private Long quantity = 0L;
    @NotNull
    private Double priceTotal = 0.0;
}
