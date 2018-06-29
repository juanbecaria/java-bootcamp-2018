package com.bootcamp2018.dto;

import com.bootcamp2018.model.Item;
import com.bootcamp2018.model.OrderDetail;


public class OrderDetailDTO {

    private int idItem;
    private int quantity;
    private double price;

    public OrderDetailDTO(int idItem, int quantity, double price) {
        this.idItem = idItem;
        this.quantity = quantity;
        this.price = price;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
