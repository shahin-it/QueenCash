package com.queen_cash.controllers.admin;

import com.queen_cash.domain.commerce.Category;
import com.queen_cash.repository.CategoryRepository;
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
@RequestMapping("categoryAdmin")
public class CategoryAdminController {
    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping("")
    String categoryList(Model model, boolean reload, @RequestParam Map params) {
        model.addAttribute("component", "category");
        model.addAttribute("count", categoryRepository.count(params));
        model.addAttribute("categories", categoryRepository.findAllByAny(params));
        return reload ? "admin/category/list" : "admin/tableView";
    }

    @RequestMapping("/edit")
    String editCategory(Model model, Long id) {
        Category category = id == null ? new Category() : categoryRepository.findOne(id);
        model.addAttribute("category", category);
        return "admin/category/edit";
    }

    @RequestMapping("/save")
    @ResponseBody
    Map save(Long id, @RequestParam Map<String, String> params) {
        Map resp = WebUtil.responseMap("Category successfully saved");
        try {
            Category category = id != null ? categoryRepository.findOne(id) : new Category();
            if(category.getId() == null) {
                category.setCreatedBy(AppUtil.loggedAdministrator());
            }
            category.setName(params.get("name"));
            category.setDescription(params.get("description"));
            categoryRepository.save(category);
        } catch (Exception e) {
            e.printStackTrace();
            resp.put("status", "error");
            resp.put("message", "Category save error!");
        }
        return resp;
    }

    @RequestMapping("/delete")
    @ResponseBody
    Map delete(Category category) {
        Map resp = WebUtil.responseMap("Category successfully removed");
        try {
            categoryRepository.delete(category);
        } catch (Exception e) {
            e.printStackTrace();
            resp.put("status", "error");
            resp.put("message", "Category remove error!");
        }
        return resp;
    }
}

