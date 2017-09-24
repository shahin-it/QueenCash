package com.queen_cash.domain;

import com.queen_cash.model.DomainBase;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer extends DomainBase {

    @NotBlank
    @Size(min = 3, max = 200)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 200)
    private String lastName;

    @NotBlank
    @NotNull
    @Size(min = 3, max = 200)
    @Column(unique = true)
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 100)
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
