/*
---------- Это sql код для создания бд в mysql---------------
CREATE DATABASE delivery_db;
USE delivery_db;

CREATE TABLE address (
    id_address INT NOT NULL AUTO_INCREMENT,
    city VARCHAR(100),
    street VARCHAR(100),
    house VARCHAR(20),
    PRIMARY KEY (id_address)
);

CREATE TABLE parcel (
    id_parcel INT NOT NULL AUTO_INCREMENT,
    weight DOUBLE,
    sender_name VARCHAR(100),
    id_address INT,
    PRIMARY KEY (id_parcel),
    FOREIGN KEY (id_address) REFERENCES address(id_address)
);

INSERT INTO address VALUES (NULL, 'Москва', 'Ленина', '10');
INSERT INTO parcel VALUES (NULL, 2.5, 'Иван Иванов', 1);
*/



package Lab1;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("Не удалось загрузить драйвер: " + e);
        }

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/delivery_db",
                "root",
                "root");

        if (conn == null) {
            System.out.println("Нет соединения с БД!");
            System.exit(0);
        }

        System.out.println("Соединение успешно установлено!");

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(
                "SELECT parcel.id_parcel, parcel.weight, parcel.sender_name, " +
                        "address.city, address.street, address.house " +
                        "FROM parcel JOIN address ON parcel.id_address = address.id_address");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("id_parcel") + ". " +
                            rs.getString("sender_name") + " | Вес: " +
                            rs.getDouble("weight") + " кг | Адрес: " +
                            rs.getString("city") + ", " +
                            rs.getString("street") + " " +
                            rs.getString("house")
            );
        }

        stmt.close();
        conn.close();
    }
}