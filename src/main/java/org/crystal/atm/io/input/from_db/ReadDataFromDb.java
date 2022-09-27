package org.crystal.atm.io.input.from_db;

import org.crystal.atm.dao.ATMs;
import org.crystal.atm.dao.Clients;
import org.crystal.atm.io.input.DataInput;

public class ReadDataFromDb extends DataInput {
    protected ReadDataFromDb(Clients clients, ATMs atmS) {
        super(clients, atmS);
    }

    public ReadDataFromDb(ATMs atmS) {
        super(atmS);
    }

    public ReadDataFromDb(Clients clients) {
        super(clients);
    }

    @Override
    public void setClientList() {

    }

    @Override
    public void setATMList() {

    }

}
