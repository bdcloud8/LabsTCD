package asyncApp;

import asyncApp.entity.Address;
import asyncApp.entity.Parcel;
import asyncApp.service.ParcelService;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManager em =
                Persistence.createEntityManagerFactory("DELIVERY_UNIT")
                        .createEntityManager();

        em.getTransaction().begin();

        Address address = new Address("Казань", "Пушкина", "7");
        em.persist(address);

        Parcel parcel = new Parcel(5.2, "Сергей Смирнов", address);
        em.persist(parcel);

        em.getTransaction().commit();

        ParcelService service = new ParcelService();

        List<Parcel> parcels = service.getAll();

        for (Parcel p : parcels) {
            System.out.println(
                    p.getId_parcel() + " | " +
                            p.getSender_name() + " | " +
                            p.getWeight() + " кг | " +
                            p.getAddress().getCity() + ", " +
                            p.getAddress().getStreet() + " " +
                            p.getAddress().getHouse()
            );
        }

        em.close();
    }
}