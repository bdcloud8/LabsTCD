package com.delivery.dao;

import com.delivery.config.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParcelDAO {

    // CREATE
    public void insertParcel(double weight,
                             String senderName,
                             int addressId)
            throws SQLException {

        String sql = "INSERT INTO parcel(weight, sender_name, id_address) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, weight);
            stmt.setString(2, senderName);
            stmt.setInt(3, addressId);

            stmt.executeUpdate();
        }
    }

    // READ ALL
    public List<String> getAllParcels() throws SQLException {

        List<String> list = new ArrayList<>();

        String sql =
                "SELECT p.id_parcel, p.weight, p.sender_name, " +
                        "a.city, a.street, a.house " +
                        "FROM parcel p " +
                        "JOIN address a ON p.id_address = a.id_address";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                String parcel =
                        rs.getInt("id_parcel") + " | " +
                                rs.getDouble("weight") + " | " +
                                rs.getString("sender_name") + " | " +
                                rs.getString("city") + ", " +
                                rs.getString("street") + " " +
                                rs.getString("house");

                list.add(parcel);
            }
        }

        return list;
    }

    // DELETE
    public void deleteParcel(int id) throws SQLException {

        String sql = "DELETE FROM parcel WHERE id_parcel = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}