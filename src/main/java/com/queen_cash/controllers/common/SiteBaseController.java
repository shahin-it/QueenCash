package com.queen_cash.controllers.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SiteBaseController {

    @RequestMapping("/")
    public String home() {
        return "site/home";
    }
}