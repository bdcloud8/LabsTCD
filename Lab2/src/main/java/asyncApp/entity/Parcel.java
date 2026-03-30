package asyncApp.entity;

import javax.persistence.*;

@Entity
@Table(name = "parcel")
@NamedQuery(name = "Parcel.getAll", query = "SELECT p FROM Parcel p")
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_parcel;

    private double weight;

    private String sender_name;

    @ManyToOne
    @JoinColumn(name = "id_address")
    private Address address;

    public Parcel() {}

    public Parcel(double weight, String sender_name, Address address) {
        this.weight = weight;
        this.sender_name = sender_name;
        this.address = address;
    }

    public Long getId_parcel() {
        return id_parcel;
    }

    public double getWeight() {
        return weight;
    }

    public String getSender_name() {
        return sender_name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "id=" + id_parcel +
                ", sender='" + sender_name + '\'' +
                ", weight=" + weight +
                ", address=" + address +
                '}';
    }
}