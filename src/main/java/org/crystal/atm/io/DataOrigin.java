package org.crystal.atm.io;

import org.crystal.atm.dao.ATMs;
import org.crystal.atm.dao.Clients;
import org.crystal.atm.model.CardDetails;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class DataOrigin {
    protected Clients clients;
    protected  ATMs atmS;

    protected DataOrigin(Clients clients, ATMs atmS){
        this.clients = clients;
        this.atmS = atmS;
    }
    protected DataOrigin(ATMs atmS) {
        this.atmS = atmS;
    }
    protected DataOrigin(Clients clients) {
        this.clients = clients;
    }
    public Map<String, CardDetails> getCardDetailerFor(String cardNr, int cardPin){
        Map<String,CardDetails> cardDetailsMap =new HashMap<>() ;
        clients.getClientsList()
                .values()
                .forEach(client ->
                        client.getClientAccountDetailsList()
                                .values()
                                .forEach(clientAccountDetails -> {
                                            clientAccountDetails.getCardList()
                                                    .stream()
                                                    .filter(cardDetails -> Objects.equals(cardDetails.getCardNr(), cardNr) && cardDetails.getCardPin() == cardPin)
                                                    .forEach(cardDetails -> cardDetailsMap.put(client.getID(),cardDetails));
                                        }


                                ));
        return cardDetailsMap ;
    }

}
