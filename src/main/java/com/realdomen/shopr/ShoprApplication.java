package com.realdomen.shopr;

import com.realdomen.shopr.domain.FictionBook;
import com.realdomen.shopr.domain.Fiction_genre;
import com.realdomen.shopr.domain.Game;
import com.realdomen.shopr.domain.Item;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ShoprApplication {

    public static void main(String[] args) {

        SpringApplication.run(ShoprApplication.class, args);

//        FictionBook fictionBook = new FictionBook();
//
//        fictionBook.setPrice(45.99);
//
//        System.out.println(fictionBook.getPrice());
//
//        Game game = new Game();
//
//        game.setPrice(1.0);
//
//        ArrayList<Item> itemList = new ArrayList<>();
//
//        itemList.add(fictionBook);
//        itemList.add(game);
//
//        FictionBook fictionBook2 = new FictionBook();
//
//        fictionBook2.setPrice(45.99);
//        fictionBook2.setName("The subtle art of not giving a fuck");
//        fictionBook2.setFiction_genre(Fiction_genre.DETECTIVE);
//        fictionBook2.setDescription("The wtf way to happiness");
//
//        itemList.add(fictionBook2);
//
//        System.out.println("Are game and FicBook the same? : " + game.equals(fictionBook));
//        System.out.println("Are FicBook1 and FicBook2 the same? : " + fictionBook2.equals(fictionBook));
//
//        for (Item thing : itemList) {
//            System.out.println(thing);
//
//        }
    }

}
