package com.queen_cash.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.queen_cash.domain.model.DomainBase;

import java.io.Serializable;

@NoRepositoryBean
public interface CommonRepository<T extends DomainBase> extends CrudRepository<T, Serializable> {
}
