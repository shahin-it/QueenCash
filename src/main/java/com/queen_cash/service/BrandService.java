package com.queen_cash.service;

import com.queen_cash.repository.BrandRepository;
import com.queen_cash.domain.commerce.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BrandService {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    BrandRepository brandRepository;

    @Transactional
    public List<Brand> findAll(Map<String, Object> params) {
        Pageable pageable = new PageRequest(0, 2,
                new Sort(Sort.Direction.ASC, "id")
                        .and(new Sort(Sort.Direction.ASC, "name"))
        );
        return (List<Brand>) brandRepository.findAll(pageable);
    }

    public List<Brand> list(Map<String, Object> params) {
        List<Brand> brands = new ArrayList<>();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteria = cb.createQuery(Brand.class);
        Root<Brand> root = criteria.from(Brand.class);
        String searchText;
        if((searchText = (String) params.get("searchText")) != null) {
            criteria.where(cb.or(
                    cb.like(root.get("name"), "%" + searchText + "%"),
                    cb.like(root.get("description"), "%" + searchText + "%")
            ));
        }
        TypedQuery<Brand> query = entityManager.createQuery(criteria);
        query.setFirstResult((Integer) params.get("offset"));
        query.setMaxResults((Integer) params.get("max"));
        return query.getResultList();
    }
}
