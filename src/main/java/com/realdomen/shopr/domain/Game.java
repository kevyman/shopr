package com.realdomen.shopr.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@DiscriminatorColumn(name="type")
@DiscriminatorValue(value="GAME")
@Entity
public class Game extends Item {
    private String publisher;
    private Integer min_age;
    @Enumerated(EnumType.STRING)
    private Game_genre game_genre;

}
