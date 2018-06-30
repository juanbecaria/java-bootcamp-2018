package com.bootcamp2018.service;

import com.bootcamp2018.dao.DiscountDAO;
import com.bootcamp2018.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class DiscountService implements Service<Discount> {
    @Autowired
    private DiscountDAO dDAO;

    @Override
    public Discount create(Discount object) {
        return dDAO.createDiscount(object);
    }

    @Override
    public Discount get(int id) {
        return dDAO.get(id);
    }

    @Override
    public ArrayList<Discount> getList(int id) {
        return null;
    }


    public Discount get(Discount object) {
        return dDAO.get(object.getId());
    }


    public ArrayList<Discount> getList(Discount object) {
        return dDAO.retriveItems(object);
    }

    @Override
    public Discount update(Discount object) {
        return dDAO.update(object);
    }

    @Override
    public void delete(int id) {
        dDAO.delete(id);
    }
}
