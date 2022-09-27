package org.crystal.atm.io.input;

import org.crystal.atm.dao.ATMs;
import org.crystal.atm.dao.Clients;
import org.crystal.atm.io.DataOrigin;
import org.crystal.atm.model.Client;

import java.util.Map;

public abstract class DataInput extends DataOrigin {


    protected DataInput(Clients clients, ATMs atmS) {
        super(clients, atmS);
    }

    protected DataInput(ATMs atmS) {
        super(atmS);
    }

    protected DataInput(Clients clients) {
        super(clients);
    }

    public abstract void setClientList();
    public abstract void setATMList();

    public Map<String, Client> getClientList() {
        return super.clients.getClientsList();
    }

    public void getATMList() {

    }
}
