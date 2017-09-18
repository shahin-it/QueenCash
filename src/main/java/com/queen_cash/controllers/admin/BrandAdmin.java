package com.queen_cash.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("brandAdmin")
public class BrandAdmin {

    @RequestMapping("")
    String brandList(Model model) {
        return "admin/brand/listing";
    }
}
