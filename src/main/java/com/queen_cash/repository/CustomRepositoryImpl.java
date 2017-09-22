package com.queen_cash.repository;

import com.queen_cash.domain.admin.Administrator;
import com.queen_cash.util.AppUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
public class CustomRepositoryImpl<T> extends SimpleJpaRepository<T, Serializable> implements CommonRepository<T> {
    private EntityManager entityManager;

    public CustomRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Class<T> findByCreatedBy(Administrator administrator) {
        return null;
    }

    @Override
    public List<T> findAll(Map<?, ?> params) {
        int page = params.get("offset") != null ? Integer.parseInt((String) params.get("offset")) : 0;
        int max = params.get("max") != null ? Integer.parseInt((String) params.get("max")) : 50;
        Pageable pageable = new PageRequest(page, max, Sort.Direction.ASC, "id");
        return findAll(pageable).getContent();
    }

    @Override
    public List<T> findAllByAny(Map<?, ?> params) {
        int offset = params.get("offset") != null ? Integer.parseInt((String) params.get("offset")) : 0;
        int max = params.get("max") != null ? Integer.parseInt((String) params.get("max")) : AppUtil.maxResult;
        int start = max * offset;

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteria = cb.createQuery(getDomainClass());
        Root<T> root = criteria.from(getDomainClass());
        String searchText;
        if((searchText = (String) params.get("searchText")) != null) {
            criteria.where(cb.or(
                cb.like(root.get("name"), "%" + searchText + "%"),
                cb.like(root.get("description"), "%" + searchText + "%")
            ));
        }
        TypedQuery<T> query = entityManager.createQuery(criteria);
        query.setFirstResult(start);
        query.setMaxResults(max);
        return query.getResultList();
    }

    public long count(Map<?, ?> params) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
        Root root = criteria.from(getDomainClass());
        String searchText;
        if((searchText = (String) params.get("searchText")) != null) {
            criteria.where(cb.or(
                cb.like(root.get("name"), "%" + searchText + "%"),
                cb.like(root.get("description"), "%" + searchText + "%")
            ));
        }
        criteria.select(cb.count(root));
        return entityManager.createQuery(criteria).getSingleResult();
    }
}
