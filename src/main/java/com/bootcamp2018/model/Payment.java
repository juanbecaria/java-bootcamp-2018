package com.bootcamp2018.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Payment {
    private int Id;
    @Autowired
    private Order order;
    private double amount;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Payment(int id) {
        Id = id;
    }


    public Payment(int id, Order order, double amount) {
        this.Id = id;
        this.order = order;
        this.amount = amount;
    }

    public Payment() {
        this.Id = 0;
        this.order = new Order();
        this.amount = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Payment.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final Payment other = (Payment) obj;

        if (this.getId() != other.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Payment Id: " + getId() + ", \n" + getOrder().toString() + "\nAmount: $" + getAmount();
    }

}
