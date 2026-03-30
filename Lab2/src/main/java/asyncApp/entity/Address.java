package asyncApp.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_address;

    private String city;
    private String street;
    private String house;

    public Address() {}

    public Address(String city, String street, String house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public Long getId_address() {
        return id_address;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    @Override
    public String toString() {
        return city + ", " + street + " " + house;
    }
}