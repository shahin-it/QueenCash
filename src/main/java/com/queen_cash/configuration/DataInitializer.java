package com.queen_cash.configuration;

import com.queen_cash.domain.admin.Administrator;
import com.queen_cash.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements ApplicationRunner {
    @Autowired
    private AdminRepository adminRepository;

    public void run(ApplicationArguments args) {
        if(adminRepository.count() == 0) {
            Administrator administrator = new Administrator();
            administrator.setName("Shahin Khaled");
            administrator.setEmail("admin@queencash.com");
            administrator.setPassword("admin");

            adminRepository.save(administrator);
        }
    }
}
