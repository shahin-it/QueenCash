package com.queen_cash.service;

import com.queen_cash.domain.commerce.Product;
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

    public List getValidProductList(Boolean idNameOnly) {
        Map params = new HashMap<>();
        if(idNameOnly) {

        }
        return productRepository.findAllByAny(params);
    }
}
