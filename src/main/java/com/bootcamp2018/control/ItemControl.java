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


    @RequestMapping(value="/Item/set",method = RequestMethod.PUT)
    public ResponseEntity<Item> create(@RequestBody Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return new ResponseEntity<>(itemDAO.createItem(object),HttpStatus.OK);
    }


    @RequestMapping(value="/Item/get",method = RequestMethod.POST)
    public ResponseEntity<Item> get(@RequestBody Item item) {
        ItemDAO itemDAO = new ItemDAO();
        item = itemDAO.retriveItem(item.getId());
        return new ResponseEntity<>(item,HttpStatus.OK);
    }
    @RequestMapping(value="/Item/list",method = RequestMethod.POST)
    public ResponseEntity<ArrayList<Item>> getList(@RequestBody Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return  new ResponseEntity(itemDAO.retriveItems(object),HttpStatus.OK);
    }

    @RequestMapping(value="/Item/update",method = RequestMethod.PUT)
    public ResponseEntity<Item> update(@RequestBody Item object) {
        ItemDAO itemDAO = new ItemDAO();
        return new ResponseEntity(itemDAO.updateItem(object),HttpStatus.OK);
    }

    @RequestMapping(value="/Item/delete",method = RequestMethod.POST)
    public void delete(@RequestBody Item object) {
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.deleteItem(object);
    }
}
