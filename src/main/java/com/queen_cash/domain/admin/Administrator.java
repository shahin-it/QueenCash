package com.queen_cash.domain.admin;

import com.queen_cash.constants.DomainConstant;
import com.queen_cash.model.DomainBase;
import com.queen_cash.repository.CommonRepository;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Administrator extends DomainBase {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 200)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 200)
    @Column(unique = true)
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 100)
    private String password;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String role = DomainConstant.SYSTEM_ADMIN;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static void initialize(CommonRepository adminRepository) {
        if(adminRepository.count() == 0) {
            Administrator administrator = new Administrator();
            administrator.setName("Shahin Khaled");
            administrator.setEmail("admin@queencash.com");
            administrator.setPassword("admin");

            adminRepository.save(administrator);
        }
    }

}
