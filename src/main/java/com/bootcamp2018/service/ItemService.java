package com.bootcamp2018.service;

import com.bootcamp2018.dao.ItemDAO;
import com.bootcamp2018.model.Item;
import java.util.ArrayList;

@org.springframework.stereotype.Service
public class ItemService implements Service<Item> {

    @Override
    public Item create(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.createItem(object);
    }

    @Override
    public Item get(Item Object) {
        ItemDAO itemDAO = new ItemDAO();
        Object = itemDAO.retriveItem(Object.getId());
        return Object;
    }

    @Override
    public ArrayList<Item> getList(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.retriveItems(object);
    }

    @Override
    public Item update(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.updateItem(object);
    }

    @Override
    public void delete(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.deleteItem(object);

    }
}
