package com.bootcamp2018.control;

import com.bootcamp2018.dto.OrderDetailDTO;
import com.bootcamp2018.model.Item;
import com.bootcamp2018.model.OrderDetail;
import com.bootcamp2018.service.ItemService;
import com.bootcamp2018.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
@RequestMapping("/orderDetail")
public class OrderDetailControl  {
    @Autowired
    private OrderDetailService ods;

    @RequestMapping(value="/create",method = RequestMethod.PUT)
    public ResponseEntity<OrderDetailDTO> create(@RequestBody OrderDetailDTO object) {
        return new ResponseEntity<>(ods.create(object),HttpStatus.OK);
    }

    @RequestMapping(value="/get",method = RequestMethod.POST)
    public ResponseEntity<OrderDetailDTO> get(@RequestBody OrderDetailDTO object) {
        return new ResponseEntity<>(ods.get(object),HttpStatus.OK);
    }

    @RequestMapping(value="/List",method = RequestMethod.GET)
    public ResponseEntity<ArrayList<OrderDetailDTO>> getList(OrderDetailDTO object) {
        return new ResponseEntity<>(ods.getList(object),HttpStatus.OK);
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public  ResponseEntity<OrderDetailDTO>  update(OrderDetailDTO object) {
        return new ResponseEntity<>(ods.update(object),HttpStatus.OK);
    }


    public void delete(OrderDetailDTO object) {
    }
}
