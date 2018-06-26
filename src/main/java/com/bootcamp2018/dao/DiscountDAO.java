package com.bootcamp2018.dao;

import com.bootcamp2018.db.DBConnection;
import com.bootcamp2018.model.Discount;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public class DiscountDAO {


    public Discount createDiscount(Discount discount) {
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("INSERT INTO discount (idItem, quantity, price) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, discount.getItem().getId());
            pstmt.setInt(2, discount.getQuantity());
            pstmt.setDouble(3, discount.getPrice());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                discount.setId(rs.getInt(1));
            } else {
                discount = new Discount();
            }
            pstmt.close();
        } catch (Exception e) {}
        return discount;
    }

    public Discount get(Discount discount){
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("SELECT idDiscount,idItem, quantity, price FROM discount WHERE idDiscount = ?", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, discount.getId());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                discount.setPrice(rs.getInt(4));
                discount.setQuantity(rs.getInt(3));
                ItemDAO itemDAO = new ItemDAO();
                discount.setItem(itemDAO.retriveItem(rs.getInt(2)));
            } else {
                discount = new Discount();
            }
            pstmt.close();
        } catch (Exception e) {}
        return discount;
    }

    public ArrayList<Discount> retriveItems(Discount objects) {
        ArrayList<Discount> list = new ArrayList<>();
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("SELECT idDiscount,idItem, quantity, price FROM discount");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ItemDAO itemDAO= new ItemDAO();
                list.add(new Discount(rs.getInt(1), itemDAO.retriveItem(rs.getInt(2)), rs.getInt(3),rs.getDouble(4)));
            }
            pstmt.close();
        } catch (Exception e) {}
        return list;
    }

    public Discount update(Discount discount){
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("UPDATE discount SET  quantity = ?, price= ? WHERE idDiscount = ?", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, discount.getQuantity());
            pstmt.setDouble(2, discount.getPrice());
            int resp = pstmt.executeUpdate();
            if (resp == 0) discount = new Discount();
            pstmt.close();
        } catch (Exception e) {}
        return discount;
    }

    public void delete(Discount discount) {
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("DELETE FROM Discount WHERE idItem = ?");
            pstmt.setInt(1, discount.getId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {}
    }


}
