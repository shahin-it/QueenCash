package com.queen_cash.repository;

import com.queen_cash.domain.Customer;

import javax.transaction.Transactional;

@Transactional
public interface CustomerRepository extends CommonRepository<Customer> {
}