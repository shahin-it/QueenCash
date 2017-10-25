package com.queen_cash.service;

import com.queen_cash.domain.commerce.Order;
import com.queen_cash.repository.OrderRepository;
import com.queen_cash.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order saveOrder(Long id, Map params) {
        Order order = id != null ? orderRepository.findOne(id) : new Order();
        if(order.getId() == null) {
            order.setCreatedBy(AppUtil.loggedAdministrator());
        }
        return order;
    }
}