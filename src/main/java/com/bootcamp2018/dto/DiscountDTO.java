package com.bootcamp2018.dto;

public class DiscountDTO {
    private int id;
    private int idItem;
    private int quantity;
    private double price;


    public DiscountDTO(int id,int idItem, int quantity, double price) {
        this.idItem = idItem;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int iditem) {
        this.idItem = iditem;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
