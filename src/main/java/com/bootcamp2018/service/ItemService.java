package com.bootcamp2018.service;

import com.bootcamp2018.dao.ItemDAO;
import com.bootcamp2018.model.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class ItemService implements Service<Item> {
    @Autowired
    private ItemDAO itemDAO;

    @Override
    public Item create(Item object) {
        return itemDAO.createItem(object);
    }

    @Override
    public Item get(int id) {
        Item item ;

        item = itemDAO.retriveItem(id);
        return item;
    }

    @Override
    public ArrayList<Item> getList(int id) {

        return itemDAO.retriveItems(new Item());
    }


    public Item get(Item Object) {

        Object = itemDAO.retriveItem(Object.getId());
        return Object;
    }


    public ArrayList<Item> getList(Item object) {

        return itemDAO.retriveItems(object);
    }

    @Override
    public Item update(Item object) {

        return itemDAO.updateItem(object);
    }

    @Override
    public void delete(Item object) {

        itemDAO.deleteItem(object);

    }
}
