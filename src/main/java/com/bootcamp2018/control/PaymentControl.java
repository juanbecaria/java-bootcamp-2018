package com.bootcamp2018.control;

import com.bootcamp2018.dao.PaymentDAO;
import com.bootcamp2018.dto.PaymentDTO;
import com.bootcamp2018.model.Client;
import com.bootcamp2018.model.Payment;
import com.bootcamp2018.service.PaymentService;
import com.bootcamp2018.util.DTOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
@RequestMapping("/payment")
public class PaymentControl  {
    @Autowired
    PaymentService ps;

    public PaymentDTO create(Payment object, Client client) {
        PaymentDTO paymentDTO;
        paymentDTO=  DTOUtils.toPaymentDTO(ps.create(object,client.getId()));
        return paymentDTO;


    }


    public PaymentDTO get(Payment Object) {
        return null;
    }


    public ArrayList<PaymentDTO> getList(PaymentDTO Object) {
        return null;
    }


    public PaymentDTO update(PaymentDTO Object) {
        return null;
    }

    public void delete(PaymentDTO object) {
        ps.delete(object.getId());
    }
}
