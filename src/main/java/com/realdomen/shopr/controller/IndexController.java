package com.realdomen.shopr.controller;

import com.realdomen.shopr.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private ItemService itemService;

    @GetMapping(value = "/")
    public String showUserPage(Model model) {
        model.addAttribute("allItems", itemService.getAllItems());
        return "index";
    }

    @GetMapping(value = "/admin")
    public String showAdminPage(Model model) {
        model.addAttribute("allItems", itemService.getAllItems());
        return "admin";
    }

}
