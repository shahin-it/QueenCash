package com.queen_cash.repository;

import com.queen_cash.domain.admin.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface CommonRepository<T> extends JpaRepository<T, Serializable> {
    Class<T> findByCreatedBy(Administrator administrator);
    List<T> findAll(Map<?, ?> params);
    long count(Map<?, ?> params);
    List<T> findAllByAny(Map<?, ?> params);
    List findAllByCriteria(Map<String, ?> params);
}
