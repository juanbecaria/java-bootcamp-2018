package com.bootcamp2018.control;

import com.bootcamp2018.dto.PaymentDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/payment")
public class PaymentControl  {


    public PaymentDTO create(PaymentDTO Object) {
        return Object;
    }


    public PaymentDTO get(PaymentDTO Object) {
        return null;
    }


    public ArrayList<PaymentDTO> getList(PaymentDTO Object) {
        return null;
    }


    public PaymentDTO update(PaymentDTO Object) {
        return null;
    }

    public void delete(PaymentDTO Object) {

    }
}
