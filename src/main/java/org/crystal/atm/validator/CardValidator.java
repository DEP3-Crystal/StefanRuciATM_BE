package org.crystal.atm.validator;

import org.crystal.atm.dao.Clients;
import org.crystal.atm.model.CardDetails;
import org.crystal.atm.model.Client;
import org.crystal.atm.model.ClientAccountDetails;

import java.util.Map;
import java.util.Objects;

public class CardValidator {
    public static boolean containsPin(String cardNr, int pin, Clients clients) {
        for (Map.Entry<String, Client> stringClientEntry : clients.getClientsList().entrySet()) {
            for (Map.Entry<String, ClientAccountDetails> stringClientAccountDetailsEntry : stringClientEntry.getValue().getClientAccountDetailsList().entrySet()) {
                for (CardDetails cardDetails : stringClientAccountDetailsEntry.getValue().getCardList()) {
                    return Objects.equals(cardDetails.getCardNr(), cardNr) && cardDetails.getCardPin() == pin;
                }
            }
        }
        return false;
    }

    public static boolean containsCardNr(String CardNr, Clients clients) {
        for (Map.Entry<String, Client> stringClientEntry : clients.getClientsList().entrySet()) {
            for (Map.Entry<String, ClientAccountDetails> stringClientAccountDetailsEntry : stringClientEntry.getValue().getClientAccountDetailsList().entrySet()) {
                for (CardDetails cardDetails : stringClientAccountDetailsEntry.getValue().getCardList()) {
                    return Objects.equals(cardDetails.getCardNr(), CardNr);
                }
            }
        }
        return false;
    }

    public static boolean containsPink(String CardNr, int pin) {

        return false;
    }
}
