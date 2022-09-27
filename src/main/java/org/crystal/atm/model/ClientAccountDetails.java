package org.crystal.atm.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data

public class ClientAccountDetails {
    private  String ownerID;
    private String accountNr;
    private String IBAN;
    private double amount;
    private String registrationDate;
    private String type;

    private List<Transaction> transactionList = new ArrayList<>();

    private List<CardDetails> cardList;


    public ClientAccountDetails() {
        accountNr = UUID.randomUUID().toString();

    }

    public ClientAccountDetails(String ownerID, String IBAN, double amount, String registrationDate, String type) {
        this.ownerID = ownerID;
        accountNr = UUID.randomUUID().toString();
        this.IBAN = IBAN;
        this.amount = amount;
        this.registrationDate = registrationDate;
        this.type = type;
    }

}
