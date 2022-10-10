package org.crystal.atm.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ATM {
    private String atmNr;
    private String country;
    private String city;
    private String address;
    private float latitude;
    private float longitude;
    private BigDecimal atmAmount;

    //todo look how ca do operations with BigDecimal


    public ATM(String atmNr, String country, String city, String address, float latitude, float longitude, BigDecimal atmAmount) {
        this.atmNr = atmNr;
        this.country = country;
        this.city = city;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.atmAmount = atmAmount;
    }

    public String getAtmCoordinates() {
        return latitude + "," + longitude;
    }
}
