package com.bootcamp2018.service;

import com.bootcamp2018.dao.PaymentDAO;
import com.bootcamp2018.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;


public abstract class PaymentService implements Service<Payment> {
    @Autowired
    private PaymentDAO paymentDAO;


    public Payment create(Payment object, int idClient) {
        return paymentDAO.create(object,idClient);
    }

    @Override
    public Payment get(int id) {
        return null;
    }

    @Override
    public ArrayList<Payment> getList(int id) {
        return null;
    }

    @Override
    public Payment update(Payment object) {
        return null;
    }

    @Override
    public void delete(int id) {
        paymentDAO.delete(id);
    }
}

