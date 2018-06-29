package com.bootcamp2018.util;

import com.bootcamp2018.dto.*;
import com.bootcamp2018.model.*;

import java.util.ArrayList;

public final class DTOUtils {

    public static ItemDTO toItemDTO(Item item ){
        ItemDTO itemDTO = new ItemDTO(item.getId(),item.getName(),item.getPrice());
        return itemDTO;
    }

    public static ClientDTO toClientDTO(Client client){
        ClientDTO respClientDTO;
        ArrayList<Integer> payments = new ArrayList<>();
        for (Payment payment: client.getPayments()
             ) {
            payments.add(payment.getId());
        }
        respClientDTO = new ClientDTO(client.getId(),client.getName(),client.getLastName(),client.getDescription(),payments);
        return respClientDTO;
    }

    public static OrderDetailDTO toOrderDetailDTO(OrderDetail orderDetail){
        OrderDetailDTO respOrderDetailDTO;
        respOrderDetailDTO = new OrderDetailDTO(orderDetail.getItem().getId(),orderDetail.getQuantity(),orderDetail.getPrice());
        return respOrderDetailDTO;
    }

    public static DiscountDTO toOrderDetailDTO(Discount discount){
        DiscountDTO respDiscountDTO;
        respDiscountDTO = new DiscountDTO(discount.getId(),discount.getItem().getId(),discount.getQuantity(),discount.getPrice());
        return respDiscountDTO;
    }


    public static PaymentDTO toPaymentDTO(Payment payment){
        PaymentDTO respPaymentDTO;
        respPaymentDTO = new PaymentDTO(payment.getId(),payment.getOrder().getId(),payment.getAmount());
        return  respPaymentDTO;

    }


}
