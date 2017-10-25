package com.queen_cash.configuration;

import com.queen_cash.model.CartManager;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) {
        int x = 0;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
        HttpSession session = sessionEvent.getSession();
        try {
            CartManager.getInstance().clearCart(session.getId());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
