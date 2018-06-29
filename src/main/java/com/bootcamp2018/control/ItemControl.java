package com.bootcamp2018.control;

import com.bootcamp2018.dao.ItemDAO;
import com.bootcamp2018.model.Item;

import com.bootcamp2018.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/item")
public class ItemControl {

    @Autowired
    private ItemService is;

    @RequestMapping(value="/create",method = RequestMethod.PUT)
    public ResponseEntity<Item> create(@RequestBody Item object) {
        Item item  = is.create(object);
        return new ResponseEntity<>(item,HttpStatus.OK);
    }


    @RequestMapping(value="/get",method = RequestMethod.POST)
    public ResponseEntity<Item> get(@RequestBody Item item) {
        Item response = is.get(item);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @RequestMapping(value="/list",method = RequestMethod.POST)
    public ResponseEntity<ArrayList<Item>> getList(@RequestBody Item object) {
        return  new ResponseEntity<>(is.getList(object),HttpStatus.OK);
    }

    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public ResponseEntity<Item> update(@RequestBody Item object) {

        return new ResponseEntity(is.update(object),HttpStatus.OK);
    }

    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public void delete(@RequestBody Item object) {
        is.delete(object);
    }
}
