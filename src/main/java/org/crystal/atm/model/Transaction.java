package org.crystal.atm.model;

import lombok.Data;
import org.joda.time.LocalDateTime;

@Data

public class Transaction {
    private String transNr;
    private String atmNr;
    private String sender;
    private String receiver;
    private String type;
    private LocalDateTime dateAndTime;
    private double amount;

    public Transaction(String transNr, String atmNr, String sender, String receiver, String type, double amount) {
        this.transNr = transNr;
        this.atmNr = atmNr;
        this.sender = sender;
        this.dateAndTime=LocalDateTime.now();
        this.receiver = receiver;
        this.type = type;
        this.amount = amount;
    }
}
