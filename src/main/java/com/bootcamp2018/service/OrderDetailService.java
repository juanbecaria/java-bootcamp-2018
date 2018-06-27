package com.bootcamp2018.service;

import com.bootcamp2018.dao.OrderDetailDAO;
import com.bootcamp2018.dto.OrderDetailDTO;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
@org.springframework.stereotype.Service
public class OrderDetailService implements Service<OrderDetailDTO> {

    @Autowired
    private OrderDetailDAO orderDAO;

    @Override
    public OrderDetailDTO create(OrderDetailDTO object) {
        return orderDAO.create(object);
    }

    @Override
    public OrderDetailDTO get(OrderDetailDTO object) {
        return null;
    }

    @Override
    public ArrayList<OrderDetailDTO> getList(OrderDetailDTO object) {
        return null;
    }

    @Override
    public OrderDetailDTO update(OrderDetailDTO object) {
        return null;
    }

    @Override
    public void delete(OrderDetailDTO object) {
    }
}
