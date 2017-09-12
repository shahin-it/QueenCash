package com.queen_cash.controllers.customer;

import com.queen_cash.domain.admin.Administrator;

import com.queen_cash.util.AppUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("customer")
public class CustomerController {
  
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      Administrator user = new Administrator();
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }

  @RequestMapping("/save")
  @ResponseBody
  public String create(String email, String name) {
    try {
      Administrator user = new Administrator();
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully saved!";
  }

  @RequestMapping("/logout")
  public String logout() {
    AppUtil.removeSessionAttr("customer");
    return "redirect:" + AppUtil.baseUrl() + "auth/adminLogin";
  }

} // class UserController
