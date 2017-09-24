package com.queen_cash.controllers.admin;

import com.queen_cash.domain.commerce.Product;
import com.queen_cash.repository.ProductRepository;
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
@RequestMapping("productAdmin")
public class ProductAdminController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping("")
    String productList(Model model, boolean reload, @RequestParam Map params) {
        params.put("orderBy", "desc");
        model.addAttribute("component", "product");
        model.addAttribute("count", productRepository.count(params));
        model.addAttribute("products", productRepository.findAllByAny(params));
        return reload ? "admin/product/list" : "admin/tableView";
    }

    @RequestMapping("/edit")
    String editProduct(Model model, Long id) {
        Product product = id == null ? new Product() : productRepository.findOne(id);
        model.addAttribute("product", product);
        return "admin/product/edit";
    }

    @RequestMapping("/save")
    @ResponseBody
    Map save(Long id, @RequestParam Map<String, String> params) {
        Map resp = WebUtil.responseMap("Product successfully saved");
        try {
            Product product = id != null ? productRepository.findOne(id) : new Product();
            if(product.getId() == null) {
                product.setCreatedBy(AppUtil.loggedAdministrator());
            }
            product.setName(params.get("name"));
            product.setDescription(params.get("description"));
            productRepository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
            resp.put("status", "error");
            resp.put("message", "Product save error!");
        }
        return resp;
    }

    @RequestMapping("/delete")
    @ResponseBody
    Map delete(Product product) {
        Map resp = WebUtil.responseMap("Product successfully removed");
        try {
            productRepository.delete(product);
        } catch (Exception e) {
            e.printStackTrace();
            resp.put("status", "error");
            resp.put("message", "Product remove error!");
        }
        return resp;
    }
}
