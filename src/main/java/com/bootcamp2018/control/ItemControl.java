package com.bootcamp2018.control;

import com.bootcamp2018.dao.ItemDAO;
import com.bootcamp2018.dto.ItemDTO;
import com.bootcamp2018.model.Item;

import com.bootcamp2018.service.ItemService;
import com.bootcamp2018.util.DTOUtils;
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
    public ResponseEntity<ItemDTO> create(@RequestBody Item object) {
        Item item  = is.create(object);
        return new ResponseEntity<>(DTOUtils.toItemDTO(item),HttpStatus.OK);
    }


    @RequestMapping(value="/get",method = RequestMethod.POST)
    public ResponseEntity<ItemDTO> get(@RequestBody Item item) {
        Item response = is.get(item);
        return new ResponseEntity<>(DTOUtils.toItemDTO(response),HttpStatus.OK);
    }
    @RequestMapping(value="/list",method = RequestMethod.POST)
    public ResponseEntity<ArrayList<ItemDTO>> getList(@RequestBody Item object) {
        ArrayList<ItemDTO> list = new ArrayList<>();
        for (Item item  :is.getList(object)
             ) {
            list.add(DTOUtils.toItemDTO(item));
        }
        return  new ResponseEntity<>(list,HttpStatus.OK);
    }

    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public ResponseEntity<ItemDTO> update(@RequestBody Item object) {
        ItemDTO itemDTO;
        itemDTO = DTOUtils.toItemDTO(is.update(object));
        return new ResponseEntity(itemDTO,HttpStatus.OK);
    }

    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public void delete(@RequestBody Item object) {
        is.delete(object.getId());
    }
}
