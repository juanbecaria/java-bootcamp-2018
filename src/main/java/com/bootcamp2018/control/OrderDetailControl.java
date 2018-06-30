package com.bootcamp2018.control;

import com.bootcamp2018.dto.OrderDetailDTO;
import com.bootcamp2018.model.*;
import com.bootcamp2018.model.OrderDetail;
import com.bootcamp2018.service.OrderDetailService;
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
@RequestMapping("/orderDetail")
public class OrderDetailControl  {
    @Autowired
    private OrderDetailService ods;

    @RequestMapping(value="/create",method = RequestMethod.PUT)
    public ResponseEntity<OrderDetailDTO> create(@RequestBody OrderDetail object) {

        return new ResponseEntity<>(DTOUtils.toDiscountDTO(ods.create(object)),HttpStatus.OK);
    }    

    @RequestMapping(value="/List",method = RequestMethod.GET)
    public ResponseEntity<ArrayList<OrderDetailDTO>> getList(@RequestBody Order object) {
        ArrayList<OrderDetailDTO> list = new ArrayList<>();
        for (OrderDetail orderDetail: ods.getList(object.getId())
                ) {
            list.add(DTOUtils.toDiscountDTO(orderDetail));
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }    

}
