package com.realdomen.shopr.repository;


import com.realdomen.shopr.domain.*;
import javassist.NotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ItemRepository(){

    }

    @Transactional
    public void saveGame(Game game){
        entityManager.persist(game);
    }

    @Transactional
    public void saveLPRecord(LPRecord lpRecord){
        entityManager.persist(lpRecord);
    }

    @Transactional
    public void saveFictionBook(FictionBook fictionBook){
        entityManager.persist(fictionBook);
    }

    @Transactional
    public void saveNonfictionBook(NonfictionBook nonfictionBook){
        entityManager.persist(nonfictionBook);
    }


    public Item findByIdAndType(Integer id, Class<? extends Item> type){
        return entityManager.find(type,id);
    }

    public List<Item> getAllItems(){
        List<Item> items = new ArrayList<>();
        items.addAll(entityManager.createQuery("select g from Game g", Game.class).getResultList());
        items.addAll(entityManager.createQuery("select b from Book b", Book.class).getResultList());
        items.addAll(entityManager.createQuery("select l from LPRecord l", LPRecord.class).getResultList());
        return items;
    }

    @Transactional
    public void updateItem(Item item){
        entityManager.merge(item);
    }

    @Transactional
    public void removeByIdAndType(Integer id, Class<? extends Item> type) throws NotFoundException {
        Item item = findByIdAndType(id, type);
        entityManager.remove(item);
    }

}
