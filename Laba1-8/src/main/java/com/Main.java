package com;

import com.delivery.dao.AddressDAO;
import com.delivery.dao.ParcelDAO;

public class Main {

    public static void main(String[] args) {

        AddressDAO addressDAO = new AddressDAO();
        ParcelDAO parcelDAO = new ParcelDAO();

        try {

            addressDAO.insertAddress("Moscow", "Lenina", "10");
            parcelDAO.insertParcel(2.5, "Ivan Ivanov", 1);

            System.out.println(addressDAO.getAllAddresses());
            System.out.println(parcelDAO.getAllParcels());

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}