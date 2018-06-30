package com.bootcamp2018.control;

import com.bootcamp2018.dao.PaymentDAO;
import com.bootcamp2018.dto.OrderDetailDTO;
import com.bootcamp2018.dto.PaymentDTO;
import com.bootcamp2018.model.Client;
import com.bootcamp2018.model.OrderDetail;
import com.bootcamp2018.model.Payment;
import com.bootcamp2018.service.PaymentService;
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
@RequestMapping("/payment")
public class PaymentControl  {
    @Autowired
    PaymentService ps;


    @RequestMapping(value="/create",method = RequestMethod.PUT)
    public ResponseEntity<PaymentDTO> create(@RequestBody Payment object, @RequestBody Client client) {
        PaymentDTO paymentDTO;
        paymentDTO=  DTOUtils.toPaymentDTO(ps.create(object,client.getId()));
        return new ResponseEntity<>(paymentDTO,HttpStatus.OK);;


    }

    @RequestMapping(value="/get",method = RequestMethod.POST)
    public ResponseEntity<PaymentDTO> get(@RequestBody Payment Object) {
        PaymentDTO paymentDTO;
        paymentDTO=  DTOUtils.toPaymentDTO(ps.get(Object.getId()));
        return new ResponseEntity<>(paymentDTO,HttpStatus.OK);;

    }

    @RequestMapping(value="/list",method = RequestMethod.POST)
    public ResponseEntity<ArrayList<PaymentDTO>> getList(@RequestBody Client object) {
        ArrayList<PaymentDTO> list = new ArrayList<>();
        for (Payment payment: ps.getList(object.getId())
                ) {
            list.add(DTOUtils.toPaymentDTO(payment));
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }



    @RequestMapping(value="/delete",method = RequestMethod.DELETE)
    public void delete(@RequestBody PaymentDTO object) {
        ps.delete(object.getId());
    }
}
