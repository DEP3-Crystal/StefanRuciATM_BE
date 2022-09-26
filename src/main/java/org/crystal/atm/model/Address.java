package org.crystal.atm.model;

import lombok.Data;

@Data
public class Address {
    private String country;
    private String city;
    private String address;

    public Address(String country, String city, String address) {
        this.country = country;
        this.city = city;
        this.address = address;
    }
}