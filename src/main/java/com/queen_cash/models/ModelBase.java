package com.queen_cash.models;

import com.queen_cash.models.admin.Administrator;
import com.queen_cash.util.AppUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedSuperclass
public abstract class ModelBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private long id;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date created = AppUtil.currentDateTime();

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "created_by_id")
    private Administrator createdBy = AppUtil.loggedAdministrator();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Administrator getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Administrator createdBy) {
        this.createdBy = createdBy;
    }
}
