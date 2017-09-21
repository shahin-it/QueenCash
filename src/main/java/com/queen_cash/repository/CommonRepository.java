package com.queen_cash.repository;

import com.queen_cash.domain.admin.Administrator;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.queen_cash.model.DomainBase;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface CommonRepository<T> extends JpaRepository<T, Serializable> {
    Object findByCreatedBy(Administrator administrator);
    public List<T> findAll(Map params);
}
