package com.bootcamp2018.service;

import com.bootcamp2018.dao.ClientDAO;
import com.bootcamp2018.model.Client;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class ClientService implements Service<Client> {
    @Autowired
    private ClientDAO clientDAO;

    @Override
    public Client get(int id) {
        return  clientDAO.get(id);
    }

    @Override
    public ArrayList<Client> getList(int id) {
        return clientDAO.list();
    }

    @Override
    public Client create(Client object) {
       return  clientDAO.create(object);
    }


    public Client get(Client object) {
        return  clientDAO.get(object);
    }


    public ArrayList<Client> getList(Client object) {
        return clientDAO.list();
    }

    @Override
    public Client update(Client object) {
        return clientDAO.update(object);
    }

    @Override
    public void delete(Client object) {
        clientDAO.delete(object);
    }
    //DTO class  ver patron
}
