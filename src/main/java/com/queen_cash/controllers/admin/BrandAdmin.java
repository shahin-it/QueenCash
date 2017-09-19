package com.queen_cash.controllers.admin;

import com.queen_cash.domain.commerce.Brand;
import com.queen_cash.repository.BrandRepository;
import com.queen_cash.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("brandAdmin")
public class BrandAdmin {

    @Autowired
    BrandRepository brandRepository;

    @RequestMapping("")
    String brandList(Model model) {
        model.addAttribute("brands", brandRepository.findAll());
        return "admin/brand/listing";
    }

    @RequestMapping("/edit")
    String editBrand(Model model, Long id) {
        Brand brand = id == null ? new Brand() : brandRepository.findOne(id);
        model.addAttribute("brand", brand);
        return "admin/brand/edit";
    }

    @RequestMapping("/save")
    @ResponseBody
    Map save(Brand brand) {
        Map resp = new HashMap();
        try {
            if(brand.getId() == null) {
                brand.setCreatedBy(AppUtil.loggedAdministrator());
            }
            brandRepository.save(brand);
            resp.put("message", "Brand save success");
        } catch (Exception e) {
            e.printStackTrace();
            resp.put("message", "Brand save error!");
        }
        return resp;
    }
}
