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
@DiscriminatorValue(value = "NonfictionBook")
@Entity
public class NonfictionBook extends Book{
    @Enumerated(EnumType.STRING)
    private Nonfiction_subject nonfiction_subject;

}
