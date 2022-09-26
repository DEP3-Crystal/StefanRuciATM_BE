package org.crystal.atm.model;

import lombok.Data;

@Data

public class Transaction {
    private String id;
    private String sender;
    private  String type;
    private String date;
    private String time;
    private double amount;
    private String receiver;
}
