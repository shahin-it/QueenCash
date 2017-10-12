package com.queen_cash.controllers;

import com.queen_cash.service.ProductService;
import com.queen_cash.util.AppUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("")
    String index(Model model) {
        model.addAttribute("message", AppUtil.getBean(ProductService.class).getValidProductList());
        return "test";
    }
}
