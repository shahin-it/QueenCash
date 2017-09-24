package com.queen_cash.domain.commerce;

import com.queen_cash.model.DomainBase;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class OrderItem extends DomainBase {
    private Long productId;
    @NotNull
    @NotBlank
    private String productName;

    @NotNull
    private Long quantity = 0L;

    @NotNull
    private Double sellsPrice = 0.0;

    @NotNull
    private Double costPrice = 0.0;

}
