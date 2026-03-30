package asyncApp.service;

import asyncApp.entity.Address;
import asyncApp.entity.Parcel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.*;

public class ParcelServiceTest {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static ParcelService service;

    @BeforeClass
    public static void init() {
        emf = Persistence.createEntityManagerFactory("DELIVERY_UNIT");
        em = emf.createEntityManager();
        service = new ParcelService();
    }

    @AfterClass
    public static void close() {
        em.close();
        emf.close();
    }

    @Test
    public void testAddParcel() {

        em.getTransaction().begin();

        Address address = new Address("JUnitГород", "JUnitУлица", "5");
        em.persist(address);

        Parcel parcel = new Parcel(8.0, "JUnit Отправитель", address);
        em.persist(parcel);

        em.getTransaction().commit();

        assertNotNull(parcel.getId_parcel());
    }

    @Test
    public void testGetAll() {
        List<Parcel> parcels = service.getAll();
        assertTrue(parcels.size() > 0);
    }
}