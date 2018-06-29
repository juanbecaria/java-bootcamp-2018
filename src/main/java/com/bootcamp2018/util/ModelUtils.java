package com.bootcamp2018.util;

import com.bootcamp2018.dao.ItemDAO;
import com.bootcamp2018.dao.PaymentDAO;
import com.bootcamp2018.dto.*;
import com.bootcamp2018.model.*;

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

    public static OrderDetail toOrderDetail(OrderDetailDTO orderDetailDTO){
        OrderDetail respOrederDetail;
        ItemDAO itemDAO = new ItemDAO();
        Item item;
        item = itemDAO.retriveItem(orderDetailDTO.getIdItem());
        respOrederDetail = new OrderDetail(item,orderDetailDTO.getQuantity(),orderDetailDTO.getPrice());
        return respOrederDetail;
    }

    public static Discount toDiscount(DiscountDTO discountDTO){
        Discount respDiscount;
        ItemDAO itemDAO = new ItemDAO();
        Item item;
        item = itemDAO.retriveItem(discountDTO.getIdItem());
        respDiscount = new Discount(discountDTO.getId(),item,discountDTO.getQuantity(),discountDTO.getPrice());
        return respDiscount;
    }


}
