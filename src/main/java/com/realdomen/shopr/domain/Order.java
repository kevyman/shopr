package com.realdomen.shopr.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
//
//@Data
//@NoArgsConstructor
//@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;

    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime localDateTime;

    @OneToMany
    private List<OrderItem> itemList;

    private double total = 0;

    @Transient
    public void add(OrderItem orderItem){
        itemList.add(orderItem);
//        total += orderItem.getItem();

    }
}
