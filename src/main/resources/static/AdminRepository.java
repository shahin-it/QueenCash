package com.queen_cash.util.repo;

import com.queen_cash.domain.admin.Administrator;
import com.queen_cash.repository.CommonRepository;

import javax.transaction.Transactional;

@Transactional
public interface AdminRepository extends CommonRepository<Administrator> {
    public Administrator findByEmailAndPassword(String email, String password);
    public Administrator findByEmail(String email);
}
