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

    public OrderDetail create(OrderDetail orderDetail, int idOrder) {
        OrderDetail respOrderDetail = new OrderDetail(orderDetail.getItem(),orderDetail.getQuantity(),orderDetail.getPrice());
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("INSERT INTO OrderDetail (idItem,idOrder,quantity, price) VALUES (?,?,?,?)");
            pstmt.setInt(1, orderDetail.getItem().getId());
            pstmt.setInt(2, idOrder);
            pstmt.setInt(3, orderDetail.getQuantity());
            pstmt.setDouble(4, orderDetail.getPrice());
            int ok = pstmt.executeUpdate();
            pstmt.close();
            if (ok == 0){respOrderDetail= new OrderDetail();}
        } catch (Exception e) {
            respOrderDetail=new OrderDetail();
        }
        return respOrderDetail;
    }

    public ArrayList<OrderDetail> get(int idOrder) {
        ArrayList<OrderDetail> list = new ArrayList<>();
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("SELECT idItem, idOrder, quantity, price FROM orderdetail WHERE idOrder = ?", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, idOrder);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ItemDAO itemDAO = new ItemDAO();
                list.add(new OrderDetail(itemDAO.retriveItem(rs.getInt(2)), rs.getInt(3),rs.getDouble(4)));
            }
            pstmt.close();
        } catch (Exception e) {
            list = new ArrayList<>();
        }
        return list;
    }




}
