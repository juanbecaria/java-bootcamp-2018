package com.bootcamp2018.dto;

public class DiscountDTO {
    private int iditem;
    private int quantity;
    private double price;
    private int id;

    public DiscountDTO(int iditem, int quantity, double price, int id) {
        this.iditem = iditem;
        this.quantity = quantity;
        this.price = price;
        this.id = id;
    }

    public int getIditem() {
        return iditem;
    }

    public void setIditem(int iditem) {
        this.iditem = iditem;
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
