package com.bootcamp2018.control;

import com.bootcamp2018.dao.ItemDAO;
import com.bootcamp2018.model.Item;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class ItemControl {



    public Item create(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.createItem(object);
    }

    @RequestMapping(value="/list/get",method = RequestMethod.POST)
    public ResponseEntity<Item> get(@RequestBody Item item) {
        ItemDAO itemDAO = new ItemDAO();
        item = itemDAO.retriveItem(item.getId());
        return new ResponseEntity<>(item,HttpStatus.OK);
    }
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public String getList(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        String str= "";
        for (Item it: itemDAO.retriveItems(object)
             ) {
            str += it.toString();
        }

        return  str;
    }


    public Item update(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return itemDAO.updateItem(object);
    }


    public void delete(Item object) {
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.deleteItem(object);

    }
}
