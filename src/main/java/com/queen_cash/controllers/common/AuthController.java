package com.queen_cash.controllers.common;

import com.queen_cash.domain.admin.Administrator;
import com.queen_cash.repository.AdminRepository;
import com.queen_cash.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("auth")
public class AuthController {
    @Autowired
    AdminRepository adminRepository;

    @RequestMapping("/adminLogin")
    public String adminLogin(String email, String password, boolean remember) {
        Long adminId = AppUtil.loggedAdmin();
        if(adminId != null) {
            Administrator administrator = adminRepository.findOne(adminId);
            if(administrator.getId() == adminId) {
                return "redirect:" + AppUtil.baseUrl() + "admin";
            } else {
                AppUtil.removeSessionAttr("admin");
            }
        }
        return "admin/login";
    }

    @RequestMapping("/authenticateAdmin")
    public String authenticateAdmin(String email, String password, Boolean remember) {
        Administrator administrator = adminRepository.findByEmailAndPassword(email, password);
        if(administrator != null) {
            AppUtil.addSessionAttr("admin", administrator.getId());
            return "redirect:"+AppUtil.baseUrl()+"admin";
        }
        return "redirect:" + AppUtil.baseUrl() + "auth/adminLogin";
    }

    @RequestMapping("/resetAdminPassword")
    public String resetAdminPassword() {
        return "";
    }

    @RequestMapping("/registerCustomer")
    public String registerCustomer(@RequestParam Map<String,String> params, ModelMap model) {
        return "";
    }

    @RequestMapping("/resetCustomerPassword")
    public String resetCustomerPassword(String email) {
        return "";
    }
}
