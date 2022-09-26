package org.crystal.atm.model;

import lombok.Data;

@Data
public class ATM {
    private String atmNr;
    private String atmName;
    private String atmGPSCoordinates;
    private double atmAmount;

    public ATM(String atmNr, String atmName, String atmGPSCoordinates, double atmAmount) {
        this.atmNr=atmNr;
        this.atmName = atmName;
        this.atmGPSCoordinates = atmGPSCoordinates;
        this.atmAmount = atmAmount;
    }
}
