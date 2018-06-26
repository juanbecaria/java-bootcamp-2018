package com.bootcamp2018.control;


import com.bootcamp2018.model.Discount;
import com.bootcamp2018.service.DiscountService;
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
    public ResponseEntity<Discount> create(@RequestBody Discount object) {
        return new ResponseEntity<>(ds.create(object),HttpStatus.OK);
    }

    @RequestMapping(value="/get",method = RequestMethod.POST)
    public ResponseEntity<Discount> get(@RequestBody Discount object) {
        return  new ResponseEntity<>(ds.get(object),HttpStatus.OK);
    }

    @RequestMapping(value="/list",method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Discount>> getList() {
        return new ResponseEntity<>(ds.getList(new Discount()),HttpStatus.OK);
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public ResponseEntity<Discount> update(@RequestBody Discount object) {
        return new ResponseEntity<>(ds.update(object), HttpStatus.OK);
    }

    @RequestMapping(value="/delete",method = RequestMethod.POST)
    public void delete(@RequestBody Discount object) {
        ds.delete(object);
    }
}
