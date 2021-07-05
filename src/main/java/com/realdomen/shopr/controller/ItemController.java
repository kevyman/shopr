package com.realdomen.shopr.controller;

import com.realdomen.shopr.domain.*;
import com.realdomen.shopr.service.ItemService;
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
        // create model attribute to bind form data
        Game game = new Game();
        model.addAttribute("game", game);
        model.addAttribute("gameGenreList", Game_genre.values());
        return "addGame";
    }

    @GetMapping("/addLPRecord")
    public String showNewLPRecordForm(Model model) {
        // create model attribute to bind form data
        LPRecord lpRecord = new LPRecord();
        model.addAttribute("lpRecord", lpRecord);
        model.addAttribute("musicGenreList", Music_genre.values());
        return "addLPRecord";
    }

    @GetMapping("/addFictionBook")
    public String showNewFictionBookForm(Model model) {
        // create model attribute to bind form data
        FictionBook fictionBook = new FictionBook();
        model.addAttribute("fictionBook", fictionBook);
        model.addAttribute("fictionGenreList", Fiction_genre.values());
        return "addFictionBook";
    }

    @GetMapping("/addNonfictionBook")
    public String showNewNonfictionBookForm(Model model) {
        // create model attribute to bind form data
        NonfictionBook nonfictionBook = new NonfictionBook();
        model.addAttribute("nonfictionBook", nonfictionBook);
        model.addAttribute("subjectList", Nonfiction_subject.values());
        return "addNonfictionBook";
    }

    @GetMapping("/editGame/{id}")
    public String showEditGameForm(@PathVariable(value = "id") int id, Model model) {
        Game game = new Game();
        Item item = itemService.findByIdAndType(id,game.getClass());
        game = (Game) item;
        model.addAttribute("game", game);
        model.addAttribute("gameGenreList", Game_genre.values());
        return "updateGame";
    }

    @GetMapping("/editLPRecord/{id}")
    public String showEditLPRecordForm(@PathVariable(value = "id") int id, Model model) {

        LPRecord lpRecord = new LPRecord();
        Item item = itemService.findByIdAndType(id,lpRecord.getClass());
        lpRecord = (LPRecord) item;
        model.addAttribute("lpRecord", lpRecord);
        model.addAttribute("musicGenreList", Music_genre.values());
        return "updateLPRecord";
    }

    @GetMapping("/editFictionBook/{id}")
    public String showEditFictionBookForm(@PathVariable(value = "id") int id, Model model) {

        FictionBook fictionBook = new FictionBook();
        Item item = itemService.findByIdAndType(id,fictionBook.getClass());
        fictionBook = (FictionBook) item;
        model.addAttribute("fictionBook", fictionBook);
        model.addAttribute("fictionGenreList", Fiction_genre.values());
        return "updateFictionBook";
    }

    @GetMapping("/editNonfictionBook/{id}")
    public String showEditNonfictionBookForm(@PathVariable(value = "id") int id, Model model) {

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
        Item temp = itemService.getItemOfType(type);
        Item item = itemService.findByIdAndType(id,temp.getClass());

        String page;

        switch(type){
            case "Game":
                Game game = (Game) item;
                model.addAttribute("game", game);
                page = "detailGame";
                break;
            case "LPRecord":
                LPRecord lpRecord = (LPRecord) item;
                model.addAttribute("lpRecord", lpRecord);
                page = "detailLPRecord";
                break;
            case "FictionBook":
                FictionBook fictionBook = (FictionBook) item;
                model.addAttribute("fictionBook", fictionBook);
                page = "detailFictionBook";
                break;
            case "NonfictionBook":
                NonfictionBook nonfictionBook = (NonfictionBook) item;
                model.addAttribute("nonfictionBook", nonfictionBook);
                page = "detailNonfictionBook";
                break;
            default:
                page = "error";
                break;
        }

        return page;

    }





}
