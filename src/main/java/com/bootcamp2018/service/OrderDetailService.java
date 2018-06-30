package com.bootcamp2018.service;



import com.bootcamp2018.dao.OrderDetailDAO;
import com.bootcamp2018.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
@org.springframework.stereotype.Service

public class OrderDetailService implements Service<OrderDetail> {
    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Override
    public OrderDetail create(OrderDetail object) {
        OrderDetail od;
        return null;
    }

    @Override
    public OrderDetail get(int id) {
        return null;
    }

    @Override
    public ArrayList<OrderDetail> getList(int id) {
        return null;
    }

    @Override
    public OrderDetail update(OrderDetail object) {
        return null;
    }

    @Override
    public void delete(OrderDetail object) {

    }
}
