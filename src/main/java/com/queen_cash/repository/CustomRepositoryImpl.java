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
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
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
        String orderBy = params.get("orderBy") != null ? (String) params.get("orderBy") : "asc";
        List items;

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

        if(orderBy == "asc") {
            criteria.orderBy(cb.asc(root.get("id")));
        } else {
            criteria.orderBy(cb.desc(root.get("id")));
        }

        TypedQuery<T> query = entityManager.createQuery(criteria);
        query.setFirstResult(start);
        query.setMaxResults(max);
        items = query.getResultList();
        if (items.size() == 0 && start != 0) {
            query.setFirstResult(start-max);
            items = query.getResultList();
        }
        return items;
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

    public List findAllByCriteria(Map<String, ?> params, String... projections) {
        List<Map<String, ?>> result = new ArrayList<>();
        List<Selection> selections = new ArrayList<>();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery criteria = cb.createQuery();
        Root root = criteria.from(getDomainClass());

        List<Predicate> predicates = new ArrayList();
        if(params.get("isInTrash") != null) {
            predicates.add(cb.equal(root.get("isInTrash"), params.get("isInTrash")));
        }
        criteria.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        if(projections != null && projections.length > 0) {
            for(String p:projections){
                selections.add(root.get(p).alias(p));
            }
            criteria.multiselect(selections);
        }
        Query query = entityManager.createQuery(criteria);
        query.getResultList().forEach((v)-> {
            Object[] val = (Object[]) v;
            Map row = new HashMap();
            for(int i = 0; i < projections.length; i++) {
                row.put(projections[i], val[i]);
            }
            result.add(row);
        });
        return result;
    }
}
