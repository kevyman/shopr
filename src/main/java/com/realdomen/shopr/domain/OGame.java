package com.realdomen.shopr.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class OGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity = 1;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Cart cart;


    @OneToOne(mappedBy = "oGame")
    @JsonBackReference
    private Game game;

    public void addOne(){
        this.quantity++;
    }
}
