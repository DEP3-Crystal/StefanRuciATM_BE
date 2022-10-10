package org.crystal.atm.model;

import lombok.Data;
import org.joda.time.LocalDateTime;

@Data

public class Transaction {
    private String transNr;
    private String atmNr;
    private String clientId;
    private String receiverId;
    private String clientIBAN;
    private String receiverIBAN;
    private LocalDateTime dateAndTime;
    private TransactionTypes type;//types:withdraw,deposit,transfer ,make it an Enum
    private double amount;

    public Transaction() {
    }

    public Transaction(String transNr, String atmNr, String clientId, String receiverId, String clientIBAN, String receiverIBAN, LocalDateTime dateAndTime, TransactionTypes type, double amount) {
        this.transNr = transNr;
        this.atmNr = atmNr;
        this.clientId = clientId;
        this.receiverId = receiverId;
        this.clientIBAN = clientIBAN;
        this.receiverIBAN = receiverIBAN;
        this.dateAndTime = dateAndTime;
        this.type = type;
        this.amount = amount;
    }
}
