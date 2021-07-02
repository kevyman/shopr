package com.realdomen.shopr.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@DiscriminatorColumn(name="type")
@DiscriminatorValue(value="LP_RECORD")
@NoArgsConstructor
@Entity
public class LPRecord extends Item {
    private String artist;
    @Enumerated(EnumType.STRING)
    private Music_genre music_genre;
}
