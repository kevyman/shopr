package com.realdomen.shopr.controller;

import com.realdomen.shopr.domain.Cart;
import com.realdomen.shopr.service.ItemService;
import com.realdomen.shopr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Objects;

@Controller
public class IndexController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/")
    public String showHomepage(Model model) {
        Cart cart = orderService.getNewestOrder();
//        if(Objects.isNull(cart)){
//            cart = new Cart();
//            orderService.saveOrder(cart);
//        }

        model.addAttribute("cart", cart);

        model.addAttribute("allItems", itemService.getAllItems());
        return "index";
    }

    @GetMapping(value = "/admin")
    public String showAdminPage(Model model) {
        Cart cart = orderService.getNewestOrder();

//        if(Objects.isNull(cart)){
//            cart = new Cart();
//            orderService.saveOrder(cart);
//        }

        model.addAttribute("cart", cart);

        model.addAttribute("allItems", itemService.getAllItems());
        return "admin";
    }

}
