package com.queen_cash.repository;

import com.queen_cash.domain.commerce.Brand;

import javax.transaction.Transactional;

@Transactional
public interface BrandRepository extends CommonRepository<Brand> {
}
