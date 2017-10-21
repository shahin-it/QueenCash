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
    private String name;

    @NotNull
    private Long quantity = 1L;

    @NotNull
    private Double unitPrice = 0.0;

    @NotNull
    private Double costPrice = 0.0;

    public double getTotalPrice() {
        return unitPrice * quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }
}
