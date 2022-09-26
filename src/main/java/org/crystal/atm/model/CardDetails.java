package org.crystal.atm.model;

import lombok.Data;

import java.util.regex.Pattern;

@Data
public class CardDetails {
    private final String cardNr;
    private int cardPin;
    private final int validMonth;
    private final int validYear;
    private final String ownerFullName;
    private final String ownerID;
    private final String cardType;

    public CardDetails(String cardNr, int cardPin, int validMonth, int validYear, String ownerFullName, String ownerID, String cardType) {
        this.cardNr = cardNr;
        this.cardType = cardType;
        setCardPin(cardPin);
        this.validMonth = validMonth;
        this.validYear = validYear;
        this.ownerFullName = ownerFullName;
        this.ownerID = ownerID;
    }

    public void setCardPin(int cardPin) {
        if (cardPin > 1001 && String.valueOf(cardPin).length() == 4) {
            this.cardPin = cardPin;
        }
    }

    public void changeCardPin(int newCardPin) {
        if (newCardPin > 1001 && String.valueOf(newCardPin).length() == 4) {
            this.cardPin = newCardPin;
        }
    }

}

