package com.bootcamp2018.dto;

import com.bootcamp2018.model.Order;
import com.bootcamp2018.model.Payment;

public class PaymentDTO {
    private int Id;
    private int idOrder;
    private double amount;

    public PaymentDTO(int id, int idOrder, double amount) {
        Id = id;
        this.idOrder = idOrder;
        this.amount = amount;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
