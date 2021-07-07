package com.realdomen.shopr.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@DiscriminatorColumn(name="type")
@DiscriminatorValue(value="LPRecord")
@NoArgsConstructor
@Entity
public class LPRecord extends Item {
    private String artist;
    @Enumerated(EnumType.STRING)
    private Music_genre music_genre;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "LPRecord_OLPRecord",
            joinColumns =
                    { @JoinColumn(name = "lp_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "ol_id", referencedColumnName = "id") })
    @JsonManagedReference
    private OLPRecord oLPRecord;
}
