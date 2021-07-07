package com.realdomen.shopr.controller;

import com.realdomen.shopr.domain.*;
import com.realdomen.shopr.service.ItemService;
import com.realdomen.shopr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/section/{type}")
    public String showTypeSection(@PathVariable(value="type") String type, Model model){
        Cart cart = orderService.getNewestOrder();
        model.addAttribute("cart", cart);

        model.addAttribute("type", type);
        List<Item> itemList = itemService.getAllItemsByType(type);
        model.addAttribute("itemList", itemList);
        String img;

        switch(type) {
            case "Games":
                img = "../images/gaming";
                break;

            case "Music":
                img = "../images/music";
                break;

            default:
                img = "../images/reading";
                break;
        }

        model.addAttribute("img", img);


        return "section";
    }
}
