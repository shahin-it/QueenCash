package com.queen_cash.service;

import com.queen_cash.domain.commerce.Product;
import com.queen_cash.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List getValidProductList() {
        Map params = new HashMap<>();
        List<String> projections = new ArrayList();
        projections.add("id");
        projections.add("name");
        params.put("active", true);
        params.put("isInTrash", false);
        params.put("projections", projections);
        return productRepository.findAllByCriteria(params);
    }
}
