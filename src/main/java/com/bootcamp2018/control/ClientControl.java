package com.bootcamp2018.control;

import com.bootcamp2018.model.Client;
import com.bootcamp2018.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;


@Controller
@RequestMapping("/client")
public class ClientControl {

    @Autowired
    ClientService cs;


    @RequestMapping(value="/create",method = RequestMethod.PUT)
    public ResponseEntity<Client> create(@RequestBody Client client) {
        return new ResponseEntity<>(cs.create(client),HttpStatus.OK);
    }

    @RequestMapping(value="/get",method = RequestMethod.POST)
    public ResponseEntity<Client> get(Client client) {
        return new ResponseEntity<>(cs.get(client),HttpStatus.OK);
    }

    @RequestMapping(value="/get",method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Client>> getList(@RequestBody Client client) {
        return new ResponseEntity<>(cs.getList(client),HttpStatus.OK);
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public ResponseEntity<Client> update(@RequestBody Client client) {
        return  new ResponseEntity<>(cs.update(client),HttpStatus.OK);
    }

    @RequestMapping(value="/delete",method = RequestMethod.DELETE)
    public void delete(@RequestBody Client client) {
        cs.delete(client);
    }
    //DTO class  ver patron
}
