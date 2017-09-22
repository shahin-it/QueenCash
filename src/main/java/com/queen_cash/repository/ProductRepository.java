package com.queen_cash.repository;

import com.queen_cash.domain.commerce.Product;

import javax.transaction.Transactional;

@Transactional
public interface ProductRepository extends CommonRepository<Product> {
}
