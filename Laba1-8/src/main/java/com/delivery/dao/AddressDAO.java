package com.delivery.dao;

import com.delivery.config.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {

    // CREATE
    public void insertAddress(String city, String street, String house)
            throws SQLException {

        String sql = "INSERT INTO address(city, street, house) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, city);
            stmt.setString(2, street);
            stmt.setString(3, house);

            stmt.executeUpdate();
        }
    }

    // READ ALL
    public List<String> getAllAddresses() throws SQLException {

        List<String> list = new ArrayList<>();

        String sql = "SELECT * FROM address";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String address =
                        rs.getInt("id_address") + " | " +
                                rs.getString("city") + " | " +
                                rs.getString("street") + " | " +
                                rs.getString("house");

                list.add(address);
            }
        }

        return list;
    }

    // DELETE
    public void deleteAddress(int id) throws SQLException {

        String sql = "DELETE FROM address WHERE id_address = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}