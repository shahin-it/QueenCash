package com.queen_cash.repository;

import com.queen_cash.domain.admin.Administrator;
import com.queen_cash.domain.commerce.Brand;
import com.queen_cash.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomRepositoryImpl<T> extends SimpleJpaRepository<T, Serializable> implements CommonRepository<T> {

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    public CustomRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    public Object findByCreatedBy(Administrator administrator) {
        return null;
    }

    @Transactional
    @Override
    public List<T> findAll(Map params) {
        Pageable pageable = new PageRequest(0, 2,
                new Sort(Sort.Direction.ASC, "id")
                        .and(new Sort(Sort.Direction.ASC, "name"))
        );
        return findAll(pageable).getContent();
    }
}
