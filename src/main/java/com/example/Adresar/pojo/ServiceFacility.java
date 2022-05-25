package com.example.Adresar.pojo;

import javax.persistence.*;

@Entity
@Table(name = "serviceFacility")
public class ServiceFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String address;

    private String contactNumber;

    public ServiceFacility(){

    }

    public ServiceFacility(String name, String address, String contactNumber, City city) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.city = city;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
