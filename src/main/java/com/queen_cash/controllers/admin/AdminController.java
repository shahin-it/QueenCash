package com.queen_cash.controllers.admin;

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
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    @RequestMapping("")
    public String index() {
        return "admin/controlPanel";
    }

    @RequestMapping("/login")
    public String login(String email, String password, boolean remember) {
        return "admin/login";
    }

    @RequestMapping("/authenticate")
    public String authenticate(String email, String password, Boolean remember) {
        /*Long adminId = AppUtil.loggedAdmin();
        if(adminId != null) {
            Administrator administrator = adminRepository.findOne(adminId);
            if(administrator.getId() == adminId) {
                return "admin/controlPanel";
            } else {
                AppUtil.removeSessionAttr("admin");
                return "admin/login";
            }
        } else {
            return "admin/login";
        }*/
        Administrator administrator = adminRepository.findByEmailAndPassword(email, password);
        if(administrator != null) {
            AppUtil.addSessionAttr("admin", administrator.getId());
            return "redirect:"+AppUtil.baseUrl()+"admin";
        }
        return "redirect:" + AppUtil.baseUrl() + "admin/login";
    }

    @RequestMapping("/register")
    public String register(@RequestParam Map<String,String> params, ModelMap model) {
        return "";
    }

    @RequestMapping("/resetPassword")
    public String resetPassword(String email) {
        return "";
    }
}
