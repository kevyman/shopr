package com.realdomen.shopr.service;

import com.realdomen.shopr.domain.*;
import com.realdomen.shopr.repository.ItemRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void saveGame(Game game){
        itemRepository.saveGame(game);
    }

    public void saveLPRecord(LPRecord lpRecord){
        itemRepository.saveLPRecord(lpRecord);
    }

    public void saveFictionBook(FictionBook fictionBook){
        itemRepository.saveFictionBook(fictionBook);
    }

    public void saveNonfictionBook(NonfictionBook nonfictionBook){
        itemRepository.saveNonfictionBook(nonfictionBook);
    }


    public void updateFictionBook(FictionBook fictionBook) {
        itemRepository.updateFictionBook(fictionBook);
    }


    public void updateNonfictionBook(NonfictionBook nonfictionBook) {
        itemRepository.updateNonfictionBook(nonfictionBook);
    }


    public void updateGame(Game game) {
        itemRepository.updateGame(game);
    }


    public void updateLPRecord(LPRecord lpRecord) {
        itemRepository.updateLPRecord(lpRecord);
    }

    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    public void updateItem(Item item){
        itemRepository.updateItem(item);
    }

    public void removeByIdAndType(Integer id, Class<? extends Item> type) throws NotFoundException {
        itemRepository.removeByIdAndType(id,type);
    }

    public Item findByIdAndType(Integer id, Class<? extends Item> type){
        return itemRepository.findByIdAndType(id, type);
    }

    public Item getItemOfType(String type){
        Item item;

        switch(type){

            case "FictionBook":
                item = new FictionBook();
                break;
            case "NonfictionBook":
                item = new NonfictionBook();
                break;
            case "LPRecord":
                item = new LPRecord();
                break;
            default:
                item = new Game();
                break;
        }

        return item;
    }

}
