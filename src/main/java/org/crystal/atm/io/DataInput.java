package org.crystal.atm.io;

import org.crystal.atm.dao.ATMs;
import org.crystal.atm.dao.Clients;
import org.crystal.atm.model.Client;

import java.util.Map;

public abstract class DataInput {
 private   Clients clients;
 private ATMs atmS;

    protected DataInput(Clients clients, ATMs atmS){
        this.clients = clients;
        this.atmS = atmS;
    }
protected DataInput( ATMs atmS) {
        this.atmS = atmS;
    }
protected DataInput(Clients clients) {
        this.clients = clients;
    }

    public abstract void setClientList();
    public abstract void setATMList();

    public Map<String, Client> getClientList() {
        return clients.getClientsList();
    }

    public void getATMList() {

    }
}
