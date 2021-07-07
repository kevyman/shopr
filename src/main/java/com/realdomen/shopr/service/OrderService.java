package com.realdomen.shopr.service;


import com.realdomen.shopr.domain.Cart;
import com.realdomen.shopr.repository.OrderRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public void saveOrder(Cart cart){
        orderRepository.saveOrder(cart);
    }

    public void updateOrder(Cart cart){
        orderRepository.updateOrder(cart);
    }

    public Cart findOrderById(Integer id){
        return orderRepository.findOrderById(id);
    }

    public Cart getNewestOrder() {
        return orderRepository.getNewestOrder();
    }

    public List<Cart> getOrderHistory(){
        return orderRepository.getOrderHistory();
    }
}
