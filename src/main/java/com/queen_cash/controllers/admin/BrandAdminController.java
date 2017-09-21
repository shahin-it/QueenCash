package com.queen_cash.controllers.admin;

import com.queen_cash.domain.commerce.Brand;
import com.queen_cash.repository.BrandRepository;
import com.queen_cash.util.AppUtil;
import com.queen_cash.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("brandAdmin")
public class BrandAdminController {

    @Autowired
    BrandRepository brandRepository;

    @RequestMapping("")
    String brandList(Model model, boolean reload, @RequestParam Map params) {
        model.addAttribute("count", brandRepository.count());
        if(params.get("max") == null) {
            params.put("max", "10");
        }
        model.addAttribute("brands", brandRepository.findAll(params));
        return reload ? "admin/brand/brandTable" : "admin/brand/appView";
    }

    @RequestMapping("/edit")
    String editBrand(Model model, Long id) {
        Brand brand = id == null ? new Brand() : brandRepository.findOne(id);
        model.addAttribute("brand", brand);
        return "admin/brand/edit";
    }

    @RequestMapping("/save")
    @ResponseBody
    Map save(Long id, @RequestParam Map<String, String> params) {
        Map resp = WebUtil.responseMap("Brand save success");
        try {
            Brand brand = id != null ? brandRepository.findOne(id) : new Brand();
            if(brand.getId() == null) {
                brand.setCreatedBy(AppUtil.loggedAdministrator());
            }
            brand.setName(params.get("name"));
            brand.setDescription(params.get("description"));
            brandRepository.save(brand);
        } catch (Exception e) {
            e.printStackTrace();
            resp.put("status", "error");
            resp.put("message", "Brand save error!");
        }
        return resp;
    }

    @RequestMapping("/delete")
    @ResponseBody
    Map delete(Brand brand) {
        Map resp = WebUtil.responseMap("Brand remove success");
        try {
            brandRepository.delete(brand);
        } catch (Exception e) {
            e.printStackTrace();
            resp.put("status", "error");
            resp.put("message", "Brand remove error!");
        }
        return resp;
    }
}
