package com.bootcamp2018.dao;

import com.bootcamp2018.db.DBConnection;
import com.bootcamp2018.dto.OrderDetailDTO;
import com.bootcamp2018.dto.PaymentDTO;
import com.bootcamp2018.model.OrderDetail;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public class OrderDetailDAO {

    public OrderDetailDTO create(OrderDetailDTO orderDetail) {
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("INSERT INTO OrderDetail (idItem,idOrder,quantity, price) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, orderDetail.getOrderDetail().getItem().getId());
            pstmt.setInt(2, orderDetail.getIdOrder());
            pstmt.setInt(2, orderDetail.getOrderDetail().getQuantity());
            pstmt.setDouble(2, orderDetail.getOrderDetail().getPrice());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (!rs.next()) {
                orderDetail.setOrderDetail(new OrderDetail());
            }
            pstmt.close();
        } catch (Exception e) {
            orderDetail.setOrderDetail(new OrderDetail());
        }
        return orderDetail;
    }

    public ArrayList<OrderDetailDTO> get(OrderDetailDTO orderDetail) {
        ArrayList<OrderDetailDTO> list = new ArrayList<>();
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("SELECT idItem, idOrder, quantity, price FROM orderdetail WHERE (NOT idOrder = 0 AND idOrder = ?) OR (NOT idItem = 0 AND idItem = ?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, orderDetail.getIdOrder());
            pstmt.setInt(2, orderDetail.getOrderDetail().getItem().getId());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ItemDAO itemDAO = new ItemDAO();
                list.add(new OrderDetailDTO(rs.getInt(2), new OrderDetail(itemDAO.retriveItem(rs.getInt(2)), rs.getInt(3),rs.getDouble(4))));
            }
            pstmt.close();
        } catch (Exception e) {
            list = new ArrayList<>();
        }
        return list;
    }




}
