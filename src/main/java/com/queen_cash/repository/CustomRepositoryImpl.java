package com.queen_cash.repository;

import com.queen_cash.domain.admin.Administrator;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
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

    @Override
    public List<T> findAll(Map<?, ?> params) {
        int page = params.get("offset") != null ? Integer.parseInt((String) params.get("offset")) : 0;
        int max = params.get("max") != null ? Integer.parseInt((String) params.get("max")) : 100;
        Pageable pageable = new PageRequest(page, max,
                new Sort(Sort.Direction.ASC, "id")
                        .and(new Sort(Sort.Direction.ASC, "name"))
        );
        return findAll(pageable).getContent();
    }
}
