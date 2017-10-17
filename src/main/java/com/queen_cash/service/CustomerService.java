package com.queen_cash.service;

import com.queen_cash.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List getValidCustomer() {
        List customers = new ArrayList();
        customerRepository.findAllByCriteria(new HashMap<>(), "id", "firstName", "lastName").forEach((v)-> {
            Map customer = (Map) v;
            customer.put("name", customer.get("firstName") + (customer.get("lastName") !=null ? " " + customer.get("lastName") : ""));
            customers.add(customer);
        });
        return customers;
    }
}
