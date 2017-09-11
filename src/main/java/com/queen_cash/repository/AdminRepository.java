package com.queen_cash.repository;

import com.queen_cash.domain.admin.Administrator;

import javax.transaction.Transactional;

@Transactional
public interface AdminRepository extends CommonRepository<Administrator> {
    public Administrator findByEmailAndPassword(String email, String password);
}
