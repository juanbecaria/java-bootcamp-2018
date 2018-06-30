package com.bootcamp2018.control;

import com.bootcamp2018.dto.*;
import com.bootcamp2018.model.Discount;
import com.bootcamp2018.service.DiscountService;
import com.bootcamp2018.util.DTOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.ArrayList;

@Controller
@RequestMapping("/discount")
public class DiscountControl {
    @Autowired
    private DiscountService ds;

    @RequestMapping(value="/create",method = RequestMethod.PUT)
    public ResponseEntity<DiscountDTO> create(@RequestBody Discount object) {
        return new ResponseEntity<>(DTOUtils.toDiscountDTO(ds.create(object)),HttpStatus.OK);
    }

    @RequestMapping(value="/get",method = RequestMethod.POST)
    public ResponseEntity<DiscountDTO> get(@RequestBody Discount object) {
        return  new ResponseEntity<>(DTOUtils.toDiscountDTO(ds.get(object)),HttpStatus.OK);
    }

    @RequestMapping(value="/list",method = RequestMethod.GET)
    public ResponseEntity<ArrayList<DiscountDTO>> getList() {
        ArrayList<DiscountDTO> list = new ArrayList<>();
        for (Discount discount:ds.getList(new Discount())
             ) {
            list.add(DTOUtils.toDiscountDTO(discount));
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public ResponseEntity<DiscountDTO> update(@RequestBody Discount object) {

        return new ResponseEntity<>(DTOUtils.toDiscountDTO(ds.update(object)), HttpStatus.OK);
    }

    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public void delete(@RequestBody Discount object) {
        ds.delete(object);
    }
}
