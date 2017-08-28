package com.queen_cash.repository;

import com.queen_cash.models.admin.Administrator;

import javax.transaction.Transactional;

@Transactional
public interface AdminRepository extends CommonRepository<Administrator> {
}
