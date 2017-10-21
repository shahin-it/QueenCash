package com.queen_cash.service;

import com.queen_cash.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List getValidProductList() {
        Map params = new HashMap<>();
        params.put("active", true);
        params.put("isInTrash", false);
        return productRepository.findAllByCriteria(params, "id", "name", "enableStock", "costPrice", "basePrice", "onSalePrice", "stockQuantity");
    }
}
