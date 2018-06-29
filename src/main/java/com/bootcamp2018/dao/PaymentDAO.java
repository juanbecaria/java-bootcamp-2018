package com.bootcamp2018.dao;

import com.bootcamp2018.db.DBConnection;

import com.bootcamp2018.model.Payment;

import java.sql.*;


public class PaymentDAO {

    public Payment create(Payment payment,int idClient) {
        Payment respPayment = new Payment();
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("INSERT INTO payment (idClient, amount) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, idClient);
            pstmt.setDouble(2, payment.getAmount());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                respPayment.setId(rs.getInt(1));
                OrderDAO orderDAO = new OrderDAO();
                respPayment.setOrder(orderDAO.create(payment.getOrder(),respPayment.getId()));
            } else {
                respPayment = new Payment();
            }
            pstmt.close();
        } catch (Exception e) {
            respPayment = new Payment();
        }
        return respPayment;
    }


    public Payment get(Payment payment){
        Payment respPayment = new Payment();
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("SELECT idPayment, amount FROM payment WHERE idPaymet = ?", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, payment.getId());
            pstmt.executeQuery();
            ResultSet rs = pstmt.getResultSet();
            if (rs.next()) {
                respPayment.setId(rs.getInt(1));
                respPayment.setAmount(rs.getDouble(2));
                OrderDAO orderDAO = new OrderDAO();
                respPayment.setOrder(orderDAO.get(payment.getOrder(),respPayment.getId()));
            } else {
                respPayment = new Payment();
            }
            pstmt.close();
        } catch (Exception e) {
            respPayment = new Payment();
        }
        return respPayment;

    }
}
