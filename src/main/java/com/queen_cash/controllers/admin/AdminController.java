package com.queen_cash.controllers.admin;

import com.queen_cash.repository.AdminRepository;
import com.queen_cash.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    @RequestMapping("")
    public String index() {
        return "admin/controlPanel";
    }

    @RequestMapping("/logout")
    public String logout() {
        AppUtil.removeSessionAttr("admin");
        return "redirect:" + AppUtil.baseUrl() + "auth/adminLogin";
    }
}
