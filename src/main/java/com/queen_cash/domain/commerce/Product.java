package com.queen_cash.domain.commerce;

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
    private Double salePrice = 0.0;
    @NotNull
    private Double costPrice = 0.0;
    @NotNull
    private Long stockQuantity = 0L;

    private String size;
    private String color;
    private String weight;
    private String weightUnit;

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

    public Boolean getOnSale() {
        return isOnSale;
    }

    public void setOnSale(Boolean onSale) {
        isOnSale = onSale;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getInTrash() {
        return isInTrash;
    }

    public void setInTrash(Boolean inTrash) {
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

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }
}