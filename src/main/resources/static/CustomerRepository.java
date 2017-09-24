package com.queen_cash.util.repo;

import com.queen_cash.domain.Customer;
import com.queen_cash.repository.CommonRepository;

import javax.transaction.Transactional;

@Transactional
public interface CustomerRepository extends CommonRepository<Customer> {
}