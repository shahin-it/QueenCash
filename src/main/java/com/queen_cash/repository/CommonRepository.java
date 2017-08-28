package com.queen_cash.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.queen_cash.models.ModelBase;

import java.io.Serializable;

@NoRepositoryBean
public interface CommonRepository<T extends ModelBase> extends CrudRepository<T, Serializable> {
}
