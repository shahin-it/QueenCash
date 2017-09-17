package com.queen_cash.configuration;

import com.queen_cash.util.AppUtil;
import org.springframework.stereotype.Component;

@Component
public class App {
    public String baseUrl() {
        return AppUtil.baseUrl();
    }
}
