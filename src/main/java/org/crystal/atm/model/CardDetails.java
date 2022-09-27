package org.crystal.atm.model;

import lombok.Data;

@Data
public class CardDetails {
    private final String cardNr;
    private int cardPin;
    private final int validMonth;
    private final int validYear;
    private final String clientId;
    private final String ownerID;
    private final String cardType;

    public CardDetails(String cardNr, int cardPin, int validMonth, int validYear, String ownerFullName, String clientId, String ownerID, String cardType) {
        this.cardNr = cardNr;
        this.clientId = clientId;
        this.cardType = cardType;
        setCardPin(cardPin);
        this.validMonth = validMonth;
        this.validYear = validYear;
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

