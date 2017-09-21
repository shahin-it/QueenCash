package com.queen_cash.repository;

import com.queen_cash.domain.admin.Administrator;
import com.queen_cash.repo.CommonCustomRepository;
import com.queen_cash.repository.CommonRepository;

import javax.transaction.Transactional;
import java.io.Serializable;

@Transactional
public interface AdminRepository extends CommonRepository<Administrator> {
    public Administrator findByEmailAndPassword(String email, String password);
    public Administrator findByEmail(String email);
}
