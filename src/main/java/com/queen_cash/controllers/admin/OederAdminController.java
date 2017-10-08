package com.queen_cash.controllers.admin;

import com.queen_cash.domain.commerce.Order;
import com.queen_cash.repository.OrderRepository;
import com.queen_cash.service.OrderService;
import com.queen_cash.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("orderAdmin")
public class OederAdminController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;
    
    @RequestMapping("")
    String orderList(Model model, boolean reload, @RequestParam Map params) {
        model.addAttribute("component", "order");
        model.addAttribute("count", orderRepository.count(params));
        model.addAttribute("orders", orderRepository.findAllByAny(params));
        return reload ? "admin/order/list" : "admin/tableView";
    }

    @RequestMapping("/edit")
    String editOrder(Model model, Long id) {
        Order order = id == null ? new Order() : orderRepository.findOne(id);
        model.addAttribute("order", order);
        return "admin/order/edit";
    }

    @RequestMapping("/save")
    @ResponseBody
    Map save(Long id, @RequestParam Map<String, String> params) {
        Map resp = WebUtil.responseMap("Order successfully created");
        try {
            orderService.saveOrder(id, params);
        } catch (Exception e) {
            e.printStackTrace();
            resp.put("status", "error");
            resp.put("message", "Order save error!");
        }
        return resp;
    }

    @RequestMapping("/delete")
    @ResponseBody
    Map delete(Long id) {
        Map resp = WebUtil.responseMap("Order successfully removed");
        try {
            Order order = orderRepository.findOne(id);
            order.setInTrash(true);
            orderRepository.save(order);
        } catch (Exception e) {
            e.printStackTrace();
            resp.put("status", "error");
            resp.put("message", "Order remove error!");
        }
        return resp;
    }
}
