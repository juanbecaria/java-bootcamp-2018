package com.bootcamp2018.dao;

import com.bootcamp2018.db.DBConnection;
import com.bootcamp2018.model.*;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;

@Repository
public class ClientDAO {

    public Client create(Client client) {
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("INSERT INTO client (name,lastName, description) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, client.getName());
            pstmt.setString(2, client.getLastName());
            pstmt.setString(3, client.getDescription());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                client.setId(rs.getInt(1));
            } else {
                client.setId(-1);
            }
            pstmt.close();
        } catch (Exception e) {
        }
        return new Client();
    }

    public ArrayList<Client> list()  {
        ArrayList<Client> list = new ArrayList<>();
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("SELECT idClient, name, lastName, description FROM client");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(ClientCreator.mapClient(rs));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Client get(Client cli){
        Client client = new Client();
        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("SELECT idClient, name, lastName, description FROM client WHERE idClient=?");
            pstmt.setString(1, cli.getName());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                client = ClientCreator.mapClient(rs);
            }
        } catch (Exception e) {
        }
        return client;
    }


    public Client delete(Client client) {

        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("DELETE FROM client WHERE idClient = ?");
            pstmt.setInt(1, client.getId());
            int resp = pstmt.executeUpdate();
            if (resp == 0) client = new Client();

        } catch (Exception e) {
            client = new Client();
        }
        return client;
    }

    public Client update(Client client)  {

        try (Connection con = DBConnection.getInstance().getDataSource().getConnection()) {
            PreparedStatement pstmt;
            pstmt = con.prepareStatement("UPDATE client SET name = ?, lastName = ?, description = ? WHERE idClient= ?");
            pstmt.setString(1, client.getName());
            pstmt.setString(2, client.getLastName());
            pstmt.setString(3, client.getDescription());
            pstmt.setInt(4, client.getId());

            int resp = pstmt.executeUpdate();
            if (resp == 0) client = new Client();

        } catch (Exception e) {
            client = new Client();
        }
        return client;
    }


    static class ClientCreator {

        private static Client mapClient(ResultSet resultSet) throws SQLException {
            Client client;
            client = new Client(resultSet.getInt(1), resultSet.getString(2), resultSet.getNString(3), resultSet.getNString(4));
            return client;
        }

    }
}
