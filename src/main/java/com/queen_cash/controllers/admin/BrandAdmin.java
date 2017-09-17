package com.queen_cash.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("brandAdmin")
public class BrandAdmin {

    @RequestMapping("/list")
    String brandList() {
        return "admin/brand/list";
    }
}
