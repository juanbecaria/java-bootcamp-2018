package com.bootcamp2018.dao;

import com.bootcamp2018.db.DBConnection;
import com.bootcamp2018.model.Order;
import com.bootcamp2018.model.OrderDetail;
import java.sql.*;
import java.util.ArrayList;

public class OrderDAO {
    public Order create(Order order, int idPayment) {
        Order respOrder = new Order();
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("INSERT INTO Order (idPayment) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, idPayment);
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                respOrder.setId(rs.getInt(1));
                OrderDetail respOrderDetail;
                for (OrderDetail od : order.getOrderDetails()
                        ) {
                    OrderDetailDAO odd = new OrderDetailDAO();
                    respOrderDetail = odd.create(od,respOrder.getId());
                    respOrder.getOrderDetails().add(respOrderDetail);
                }
            } else {
                respOrder = new Order();
            }
            pstmt.close();
        } catch (Exception e) {
            respOrder = new Order();
        }
        return respOrder;
    }

    public Order get(int idPayment) {
        Order respOrder = new Order();
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("SELECT idOrder FROM 'order' WHERE idPayment = ?");
            pstmt.setInt(1, idPayment);
            pstmt.executeQuery();
            ResultSet rs = pstmt.getResultSet();
            if (rs.next()) {
                respOrder.setId(rs.getInt(1));
                ArrayList<OrderDetail> list;
                OrderDetailDAO odd = new OrderDetailDAO();
                list =  odd.get(respOrder.getId());
                respOrder.setOrderDetails(list);
            } else {
                respOrder = new Order();
            }
            pstmt.close();
        } catch (Exception e) {
            respOrder = new Order();
        }
        return respOrder;
    }

}
