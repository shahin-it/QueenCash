package com.queen_cash.model;

import com.queen_cash.domain.commerce.Order;
import com.queen_cash.domain.commerce.OrderItem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CartManager {
    private static Map<String, Order> _cart = new ConcurrentHashMap<>();

    private static CartManager _instance = null;
    protected CartManager() {

    }
    public static CartManager getInstance() {
        if(_instance == null) {
            _instance = new CartManager();
        }
        return _instance;
    }

    public Order addToCart(String sessionId, OrderItem item) {
        Order order = getCart(sessionId);
        if(order == null) {
            order = _cart.put(sessionId, new Order());
        }
        return order;
    }

    public Order getCart(String sessionId) {
        return _cart.get(sessionId);
    }

    public Boolean hasCart(String sessionId) {
        return _cart.containsKey(sessionId);
    }

    public void clearCart(String sessionId) {
        _cart.remove(sessionId);
    }
}
