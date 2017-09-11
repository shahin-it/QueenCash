package com.queen_cash.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("")
    public String index() {
        return "admin/controlPanel";
    }

    @RequestMapping("/login")
    public String login(String email, String password, boolean remember) {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "";
    }

    @RequestMapping("/resetPassword")
    public String resetPassword(String email) {
        return "";
    }
}
