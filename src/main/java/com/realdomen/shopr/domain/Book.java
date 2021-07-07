package com.realdomen.shopr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Pattern;



@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@DiscriminatorColumn(name="type")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Book extends Item {

    private String author;

    @Pattern(regexp= "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})" +
            "[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)" +
            "(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$" , message = "ISBN must be correctly formatted.")
    private String isbn;
    private Integer pages;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "Book_OBook",
            joinColumns =
                    { @JoinColumn(name = "book_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "ob_id", referencedColumnName = "id") })
    @JsonManagedReference
    private OBook oBook;

}
