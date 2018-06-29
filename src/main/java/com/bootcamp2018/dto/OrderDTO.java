package com.bootcamp2018.dto;


import com.bootcamp2018.model.Order;
import com.bootcamp2018.model.OrderDetail;

import java.util.ArrayList;

public class OrderDTO {

    private int Id;
    private ArrayList<OrderDetailDTO> orderDetails;

    public OrderDTO(int id, ArrayList<OrderDetailDTO> orderDetails) {
        Id = id;
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public ArrayList<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
