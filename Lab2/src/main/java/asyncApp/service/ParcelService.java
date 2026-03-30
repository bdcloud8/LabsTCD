package asyncApp.service;

import asyncApp.entity.Parcel;
import javax.persistence.*;
import java.util.List;

public class ParcelService {

    private EntityManager em =
            Persistence.createEntityManagerFactory("DELIVERY_UNIT")
                    .createEntityManager();

    public Parcel add(Parcel parcel) {
        em.getTransaction().begin();
        Parcel parcelFromDB = em.merge(parcel);
        em.getTransaction().commit();
        return parcelFromDB;
    }

    public void delete(long id) {
        em.getTransaction().begin();
        Parcel parcel = get(id);
        if (parcel != null) {
            em.remove(parcel);
        }
        em.getTransaction().commit();
    }

    public Parcel get(long id) {
        return em.find(Parcel.class, id);
    }

    public void update(Parcel parcel) {
        em.getTransaction().begin();
        em.merge(parcel);
        em.getTransaction().commit();
    }

    public List<Parcel> getAll() {
        TypedQuery<Parcel> query =
                em.createNamedQuery("Parcel.getAll", Parcel.class);
        return query.getResultList();
    }
}