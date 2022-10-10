package org.crystal.atm.model;

import lombok.Data;
import org.crystal.atm.exeptions.IncorrectInputEx;

@Data
public class CardDetails {
    private final String cardNr;
    private int cardPin;
    private final String clientId;
    private final String accountNr;
    private final int validMonth;
    private final int validYear;
    private final CardTypes cardType;

    public CardDetails(String cardNr, int cardPin, String accountNr, int validMonth, int validYear, String clientId, CardTypes cardType) throws IncorrectInputEx {
        this.cardNr = cardNr;
        this.accountNr = accountNr;
        this.clientId = clientId;
        this.cardType = cardType;
        setCardPin(cardPin);
        this.validMonth = validMonth;
        this.validYear = validYear;
    }

    public void setCardPin(int cardPin) throws IncorrectInputEx {
        if (cardPin > 1001 && String.valueOf(cardPin).length() == 4) {
            this.cardPin = cardPin;
        }
        else throw new IncorrectInputEx("Incorrect Value");
    }

    public void changeCardPin(int newCardPin) {
        if (newCardPin > 1001 && String.valueOf(newCardPin).length() == 4) {
            this.cardPin = newCardPin;
        }
    }

}

