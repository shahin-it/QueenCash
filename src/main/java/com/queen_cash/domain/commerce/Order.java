package com.queen_cash.domain.commerce;

import com.queen_cash.domain.Customer;
import com.queen_cash.model.DomainBase;
import com.queen_cash.util.AppUtil;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity(name = "orders")
public class Order extends DomainBase {

    private Boolean isInTrash = false;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate = AppUtil.currentDateTime();

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

    @Column(length = 500)
    private String note;

    public void addToOrderItems(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
