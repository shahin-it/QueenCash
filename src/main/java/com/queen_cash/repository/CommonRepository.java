package com.queen_cash.repository;

import com.queen_cash.domain.admin.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.queen_cash.model.DomainBase;

import java.io.Serializable;

@NoRepositoryBean
public interface CommonRepository<T extends DomainBase> extends CrudRepository<T, Serializable> {
    public Object findByCreatedBy(Administrator administrator);
}
