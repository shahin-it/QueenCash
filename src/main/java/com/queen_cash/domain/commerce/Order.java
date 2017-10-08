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

    private Boolean isInTrash = false;

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

    public Boolean getInTrash() {
        return isInTrash;
    }

    public void setInTrash(Boolean inTrash) {
        isInTrash = inTrash;
    }

    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSalesManName() {
        return salesManName;
    }

    public void setSalesManName(String salesManName) {
        this.salesManName = salesManName;
    }
}
