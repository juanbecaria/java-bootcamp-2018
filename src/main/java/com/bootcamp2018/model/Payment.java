package com.bootcamp2018.model;


public class Payment {
    private int id;
    private Order order;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.id = id;
    }


    public Payment(int id, Order order, double amount) {
        this.id = id;
        this.order = order;
        this.amount = amount;
    }

    public Payment() {
        this.id = 0;
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
        return "Payment id: " + getId() + ", \n" + getOrder().toString() + "\nAmount: $" + getAmount();
    }

}
