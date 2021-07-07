package com.realdomen.shopr.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class OLPRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity = 1;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Cart cart;


    @OneToOne(mappedBy = "oLPRecord")
    @JsonBackReference
    private LPRecord lpRecord;

    public void addOne(){
        this.quantity++;
    }
}
