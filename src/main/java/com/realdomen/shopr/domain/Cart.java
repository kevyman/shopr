package com.realdomen.shopr.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
//    private LocalDateTime localDateTime = LocalDateTime.now();



    @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<OGame> gameList = new ArrayList<>();



    @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<OLPRecord> lpList = new ArrayList<>();



    @OneToMany(
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonManagedReference
    private List<OBook> bookList = new ArrayList<>();

    public void addGame(OGame oGame){
        if(listContainsOG(oGame)){
            gameList.get(gameList.indexOf(oGame)).addOne();
        }else{
            gameList.add(oGame);
        }

    }

    public void addLP(OLPRecord olpRecord){
        if(listContainsOL(olpRecord)){
            lpList.get(lpList.indexOf(olpRecord)).addOne();
        }else{
            lpList.add(olpRecord);
        }
    }


    public void addBook(OBook oBook){
        if(listContainsOB(oBook)){
            bookList.get(bookList.indexOf(oBook)).addOne();
        }else{
            bookList.add(oBook);
        }
    }


    public void removeGame(OGame oGame){
        gameList.remove(oGame);
    }


    public void removeLP(OLPRecord orderLP){
        lpList.remove(orderLP);
    }


    public void removeBook(OBook oBook){
        bookList.remove(oBook);
    }

    public double getTotalPrice(){
        double totalBook = 0.0;
        double totalGame = 0.0;
        double totalLP = 0.0;
        if (!this.bookList.isEmpty()){
            for (OBook oBook : bookList) {
                totalBook += oBook.getBook().getPrice() * oBook.getQuantity();
            }
        }
        if (!this.gameList.isEmpty()){
            for (OGame oGame : gameList) {
                totalGame += oGame.getGame().getPrice() * oGame.getQuantity();
            }
        }
        if (!this.lpList.isEmpty()){
            for (OLPRecord olpRecord : lpList) {
                totalLP += olpRecord.getLpRecord().getPrice() * olpRecord.getQuantity();
            }
        }

        return totalBook + totalGame + totalLP;

    }

    public Integer getQuantity(){
        return bookList.size() + gameList.size() + lpList.size();
    }

    public Boolean listContainsOB(OBook oBook){
        Boolean found = false;
        for (OBook ob : bookList) {
            if(ob.getBook().getId() == oBook.getBook().getId() && ob.getBook().getType().equals(oBook.getBook().getType())){
                found = true;
            }
        }
        return found;
    }

    public Boolean listContainsOL(OLPRecord olpRecord){
        Boolean found = false;
        for (OLPRecord ol : lpList) {
            if(ol.getLpRecord().getId() == olpRecord.getLpRecord().getId()){
                found = true;
            }
        }
        return found;
    }

    public Boolean listContainsOG(OGame oGame){
        Boolean found = false;
        for (OGame og : gameList) {
            if(og.getGame().getId() == oGame.getGame().getId()){
                found = true;
            }
        }
        return found;
    }


}
