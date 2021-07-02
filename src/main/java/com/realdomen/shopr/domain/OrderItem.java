package com.realdomen.shopr.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Data
//@NoArgsConstructor
//@Entity
public class OrderItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oi_id;

    private Integer quantity;

    private Item item;



}
