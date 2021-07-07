package com.realdomen.shopr.controller;

import com.realdomen.shopr.domain.*;
import com.realdomen.shopr.service.ItemService;
import com.realdomen.shopr.service.OrderService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveGame")
    public String saveGame(@ModelAttribute("game") Game game) {
        // save item to database
        itemService.saveGame(game);
        return "redirect:/admin";
    }

    @PostMapping("/saveLPRecord")
    public String saveLPRecord(@ModelAttribute("lpRecord")LPRecord lpRecord) {
        // save item to database
        itemService.saveLPRecord(lpRecord);
        return "redirect:/admin";
    }

    @PostMapping("/saveFictionBook")
    public String saveFictionBook(@ModelAttribute("fictionBook")FictionBook fictionBook) {
        // save item to database
        itemService.saveFictionBook(fictionBook);
        return "redirect:/admin";
    }

    @PostMapping("/saveNonfictionBook")
    public String saveNonfictionBook(@ModelAttribute("nonfictionBook") NonfictionBook nonfictionBook) {
        // save item to database
        itemService.saveNonfictionBook(nonfictionBook);
        return "redirect:/admin";
    }

    @PostMapping("/updateGame")
    public String updateGame(@ModelAttribute("game") Game game) {
        // save item to database
        itemService.updateGame(game);
        return "redirect:/admin";
    }

    @PostMapping("/updateLPRecord")
    public String updateLPRecord(@ModelAttribute("lpRecord")LPRecord lpRecord) {
        // save item to database
        itemService.updateLPRecord(lpRecord);
        return "redirect:/admin";
    }

    @PostMapping("/updateFictionBook")
    public String updateFictionBook(@ModelAttribute("fictionBook")FictionBook fictionBook) {
        // save item to database
        itemService.updateFictionBook(fictionBook);
        return "redirect:/admin";
    }

    @PostMapping("/updateNonfictionBook")
    public String updateNonfictionBook(@ModelAttribute("nonfictionBook") NonfictionBook nonfictionBook) {
        // save item to database
        itemService.updateNonfictionBook(nonfictionBook);
        return "redirect:/admin";
    }

    @GetMapping("/addGame")
    public String showNewGameForm(Model model) {
        Cart cart = orderService.getNewestOrder();
        model.addAttribute("cart", cart);


        Game game = new Game();
        model.addAttribute("game", game);
        model.addAttribute("gameGenreList", Game_genre.values());
        return "addGame";
    }

    @GetMapping("/addLPRecord")
    public String showNewLPRecordForm(Model model) {
        Cart cart = orderService.getNewestOrder();
        model.addAttribute("cart", cart);

        // create model attribute to bind form data
        LPRecord lpRecord = new LPRecord();
        model.addAttribute("lpRecord", lpRecord);
        model.addAttribute("musicGenreList", Music_genre.values());
        return "addLPRecord";
    }

    @GetMapping("/addFictionBook")
    public String showNewFictionBookForm(Model model) {
        Cart cart = orderService.getNewestOrder();
        model.addAttribute("cart", cart);

        // create model attribute to bind form data
        FictionBook fictionBook = new FictionBook();
        model.addAttribute("fictionBook", fictionBook);
        model.addAttribute("fictionGenreList", Fiction_genre.values());
        return "addFictionBook";
    }

    @GetMapping("/addNonfictionBook")
    public String showNewNonfictionBookForm(Model model) {
        Cart cart = orderService.getNewestOrder();
        model.addAttribute("cart", cart);

        // create model attribute to bind form data
        NonfictionBook nonfictionBook = new NonfictionBook();
        model.addAttribute("nonfictionBook", nonfictionBook);
        model.addAttribute("subjectList", Nonfiction_subject.values());
        return "addNonfictionBook";
    }

    @GetMapping("/editGame/{id}")
    public String showEditGameForm(@PathVariable(value = "id") int id, Model model) {
        Cart cart = orderService.getNewestOrder();
        model.addAttribute("cart", cart);

        Game game = new Game();
        Item item = itemService.findByIdAndType(id,game.getClass());
        game = (Game) item;
        model.addAttribute("game", game);
        model.addAttribute("gameGenreList", Game_genre.values());
        return "updateGame";
    }

    @GetMapping("/editLPRecord/{id}")
    public String showEditLPRecordForm(@PathVariable(value = "id") int id, Model model) {
        Cart cart = orderService.getNewestOrder();
        model.addAttribute("cart", cart);

        LPRecord lpRecord = new LPRecord();
        Item item = itemService.findByIdAndType(id,lpRecord.getClass());
        lpRecord = (LPRecord) item;
        model.addAttribute("lpRecord", lpRecord);
        model.addAttribute("musicGenreList", Music_genre.values());
        return "updateLPRecord";
    }

    @GetMapping("/editFictionBook/{id}")
    public String showEditFictionBookForm(@PathVariable(value = "id") int id, Model model) {
        Cart cart = orderService.getNewestOrder();
        model.addAttribute("cart", cart);

        FictionBook fictionBook = new FictionBook();
        Item item = itemService.findByIdAndType(id,fictionBook.getClass());
        fictionBook = (FictionBook) item;
        model.addAttribute("fictionBook", fictionBook);
        model.addAttribute("fictionGenreList", Fiction_genre.values());
        return "updateFictionBook";
    }

    @GetMapping("/editNonfictionBook/{id}")
    public String showEditNonfictionBookForm(@PathVariable(value = "id") int id, Model model) {
        Cart cart = orderService.getNewestOrder();
        model.addAttribute("cart", cart);

        NonfictionBook nonfictionBook = new NonfictionBook();
        Item item = itemService.findByIdAndType(id,nonfictionBook.getClass());
        nonfictionBook = (NonfictionBook) item;
        model.addAttribute("nonfictionBook", nonfictionBook);
        model.addAttribute("subjectList", Nonfiction_subject.values());
        return "updateNonfictionBook";
    }

    @GetMapping("/deleteItem/{type}/{id}")
    public String deleteItem(@PathVariable(value = "type") String type, @PathVariable(value = "id") int id) throws NotFoundException {
        Item item = itemService.getItemOfType(type);
        itemService.removeByIdAndType(id, item.getClass());
        return "redirect:/admin";
    }

    @GetMapping("/details/{type}/{id}")
    public String showDetailsPage(@PathVariable(value="type") String type, @PathVariable(value="id") int id, Model model){
        Cart cart = orderService.getNewestOrder();

        Item temp = itemService.getItemOfType(type);
        Item item = itemService.findByIdAndType(id,temp.getClass());

        switch(type){
            case "Game":
                Game game = (Game) item;
                model.addAttribute("game", game);
//                OGame oGame = new OGame();
//                oGame.setGame(game);
//                oGame.setCart(cart);
////                model.addAttribute("oGame", oGame);
//                cart.addGame(oGame);
                model.addAttribute("cart", cart);
                return "detailGame";

            case "LPRecord":
                LPRecord lpRecord = (LPRecord) item;
                model.addAttribute("lpRecord", lpRecord);
//                OLPRecord olpRecord = new OLPRecord();
//                olpRecord.setLpRecord(lpRecord);
//                olpRecord.setCart(cart);
////                model.addAttribute("olpRecord", olpRecord);
//                cart.addLP(olpRecord);
                model.addAttribute("cart", cart);
                return "detailLPRecord";

            case "FictionBook":
                FictionBook fictionBook = (FictionBook) item;
                model.addAttribute("fictionBook", fictionBook);
//                OBook oBook = new OBook();
//                oBook.setBook(fictionBook);
//                oBook.setCart(cart);
////                model.addAttribute("oBook", oBook);
//                cart.addBook(oBook);
                model.addAttribute("cart", cart);
                return "detailFictionBook";

            case "NonfictionBook":
                NonfictionBook nonfictionBook = (NonfictionBook) item;
                model.addAttribute("nonfictionBook", nonfictionBook);
//                OBook oBook2 = new OBook();
//                oBook2.setBook(nonfictionBook);
////                model.addAttribute("oBook", oBook2);
//                cart.addBook(oBook2);
                model.addAttribute("cart", cart);
                return "detailNonfictionBook";
        }
        return "error";
    }





}
