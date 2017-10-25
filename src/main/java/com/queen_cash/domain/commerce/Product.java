package com.queen_cash.domain.commerce;

import com.queen_cash.constants.DomainConstant;
import com.queen_cash.model.DomainBase;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product extends DomainBase {
    @NotNull
    @NotBlank
    private String name;

    @Size(max = 10000)
    private String description = "";

    private Boolean isOnSale = false;
    private Boolean active = true;
    private Boolean isInTrash = false;
    private Boolean enableStock = true;

    @NotNull
    private Double basePrice = 0.0;
    @NotNull
    private Double onSalePrice = 0.0;
    @NotNull
    private Double costPrice = 0.0;
    @NotNull
    private Double discount = 0D;
    @NotNull
    private Long stockQuantity = 0L;

    private String size;
    private String color;
    private Double weight;
    private String weightUnit = "gm";//kg, gm, ml
    private String discountUnit = "percent";//percent, unit

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Boolean isOnSale) {
        isOnSale = isOnSale;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getIsInTrash() {
        return isInTrash;
    }

    public void setIsInTrash(Boolean inTrash) {
        isInTrash = inTrash;
    }

    public Boolean getEnableStock() {
        return enableStock;
    }

    public void setEnableStock(Boolean enableStock) {
        this.enableStock = enableStock;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getOnSalePrice() {
        return onSalePrice;
    }

    public void setOnSalePrice(Double onSalePrice) {
        this.onSalePrice = onSalePrice;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Long getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Long stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getDiscountUnit() {
        return discountUnit;
    }

    public void setDiscountUnit(String discountUnit) {
        this.discountUnit = discountUnit;
    }
}