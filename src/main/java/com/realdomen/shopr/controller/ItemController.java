package com.realdomen.shopr.controller;

import com.realdomen.shopr.domain.*;
import com.realdomen.shopr.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/saveGame")
    public String saveGame(@ModelAttribute("game") Game game) {
        // save item to database
        itemService.saveGame(game);
        return "redirect:/";
    }

    @PostMapping("/saveLPRecord")
    public String saveLPRecord(@ModelAttribute("lpRecord")LPRecord lpRecord) {
        // save item to database
        itemService.saveLPRecord(lpRecord);
        return "redirect:/";
    }

    @PostMapping("/saveFictionBook")
    public String saveFictionBook(@ModelAttribute("fictionBook")FictionBook fictionBook) {
        // save item to database
        itemService.saveFictionBook(fictionBook);
        return "redirect:/";
    }

    @PostMapping("/saveNonfictionBook")
    public String saveNonfictionBook(@ModelAttribute("nonfictionBook") NonfictionBook nonfictionBook) {
        // save item to database
        itemService.saveNonfictionBook(nonfictionBook);
        return "redirect:/";
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
        return "addNonFictionBook";
    }
}
