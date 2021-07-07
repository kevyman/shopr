package com.realdomen.shopr.controller;



import com.realdomen.shopr.domain.Cart;
import com.realdomen.shopr.domain.Game;
import com.realdomen.shopr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/orderHistory")
    public String showOrderHistoryPage(Model model) {
        Cart cart = orderService.getNewestOrder();
        model.addAttribute("cart", cart);

        model.addAttribute("orderList", orderService.getOrderHistory());
        return "orderHistory";
    }

    @GetMapping(value = "/cart")
    public String showCartPage(Model model) {
        Cart cart = orderService.getNewestOrder();
        model.addAttribute("cart", cart);

        model.addAttribute("orderList", orderService.getOrderHistory());
        return "cart";
    }

    @PostMapping("/updateCart")
    public String updateCart(@ModelAttribute("cart") Cart cart) {
        // save item to database
        orderService.updateOrder(cart);
        return "redirect:/";
    }


}
