package com.bootcamp2018.dto;

import com.bootcamp2018.model.Payment;

import java.util.ArrayList;

public class ClientDTO {
    private int id;
    private String name;
    private String lastName;
    private String description;
    private ArrayList<Integer> Payments;

    public ClientDTO(int id, String name, String lastName, String description, ArrayList<Integer> payments) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        Payments = payments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Integer> getPayments() {
        return Payments;
    }

    public void setPayments(ArrayList<Integer> payments) {
        Payments = payments;
    }
}
