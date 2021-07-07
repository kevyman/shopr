package com.realdomen.shopr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@DiscriminatorValue(value="Game")
@Entity
public class Game extends Item {
    private String publisher;
    private Integer min_age;
    @Enumerated(EnumType.STRING)
    private Game_genre game_genre;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "Game_OGame",
            joinColumns =
                    { @JoinColumn(name = "game_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "og_id", referencedColumnName = "id") })
    @JsonManagedReference
    private OGame oGame;

}
