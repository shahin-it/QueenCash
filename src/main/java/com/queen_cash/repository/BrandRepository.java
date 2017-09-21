package com.queen_cash.repository;

import com.queen_cash.domain.admin.Administrator;
import com.queen_cash.domain.commerce.Brand;
import com.queen_cash.repository.CommonRepository;

import javax.transaction.Transactional;
import java.io.Serializable;

@Transactional
public interface BrandRepository extends CommonRepository<Brand> {
}
