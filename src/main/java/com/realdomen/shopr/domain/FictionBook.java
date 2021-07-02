package com.realdomen.shopr.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@DiscriminatorValue(value = "FICTION_BOOK")
@Entity
public class FictionBook extends Book{

    @Enumerated(EnumType.STRING)
    private Fiction_genre fiction_genre;
    private String description;

}
