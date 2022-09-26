package org.crystal.atm.validator;

import org.crystal.atm.dao.Clients;
import org.crystal.atm.model.CardDetails;
import org.crystal.atm.model.Client;
import org.crystal.atm.model.ClientAccountDetails;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CardValidator {
    public static boolean containsPin(String cardNr, int pin) {
        for (Map.Entry<String, Client> stringClientEntry : Clients.getClientsList().entrySet()) {
            for (Map.Entry<String, ClientAccountDetails> stringClientAccountDetailsEntry : stringClientEntry.getValue().getClientAccountDetailsList().entrySet()) {
                for (CardDetails cardDetails : stringClientAccountDetailsEntry.getValue().getCardList()) {
                    return Objects.equals(cardDetails.getCardNr(), cardNr) && cardDetails.getCardPin() == pin;
                }
            }
        }
        return false;
    }
    public static boolean containsCardNr(String CardNr) {
        for (Map.Entry<String, Client> stringClientEntry : Clients.getClientsList().entrySet()) {
            for (Map.Entry<String, ClientAccountDetails> stringClientAccountDetailsEntry : stringClientEntry.getValue().getClientAccountDetailsList().entrySet()) {
                for (CardDetails cardDetails : stringClientAccountDetailsEntry.getValue().getCardList()) {
                    return Objects.equals(cardDetails.getCardNr(), CardNr) ;
                }
            }
        }
        return false;
    }

    public static boolean containsPink(String CardNr, int pin) {

        return false;
    }
}
