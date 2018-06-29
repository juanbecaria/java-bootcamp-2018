package com.bootcamp2018.util;

import com.bootcamp2018.dao.PaymentDAO;
import com.bootcamp2018.dto.ClientDTO;
import com.bootcamp2018.dto.ItemDTO;
import com.bootcamp2018.model.Client;
import com.bootcamp2018.model.Item;
import com.bootcamp2018.model.Payment;
import java.util.ArrayList;

public class ModelUtils {

    public static Item toItem (ItemDTO itemDTO ){
        Item item = new Item(itemDTO.getId(),itemDTO.getName(),itemDTO.getPrice());
        return item;
    }
    public static Client toClient (ClientDTO clientDTO ){
        ArrayList<Payment> payments = new ArrayList<>();
        PaymentDAO paymentDAO = new PaymentDAO();
        for (Integer idPayment: clientDTO.getPayments()
             ) {
            Payment payment;
            payment = paymentDAO.get(new Payment(idPayment));
            payments.add(payment);
        }
        Client client = new Client(clientDTO.getId(),clientDTO.getName(),clientDTO.getLastName(),clientDTO.getDescription(),payments);
        return client;
    }
}
