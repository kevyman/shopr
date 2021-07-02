package com.realdomen.shopr.domain;


import lombok.Data;


import javax.persistence.*;

@Data
@DiscriminatorColumn(name="type")
@MappedSuperclass
public abstract class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(insertable = false,updatable = false)
    private String type;

    private String name;

    private Double price;

    private String vendor_ID;


}
