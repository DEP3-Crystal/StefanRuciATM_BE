package org.crystal.atm.io.output.to_db;

import org.crystal.atm.dao.ATMs;
import org.crystal.atm.dao.Clients;
import org.crystal.atm.io.output.DataOutput;

public class WriteOnDb extends DataOutput {
    protected WriteOnDb(Clients clients, ATMs atmS) {
        super(clients, atmS);
    }

    protected WriteOnDb(ATMs atmS) {
        super(atmS);
    }

    protected WriteOnDb(Clients clients) {
        super(clients);
    }

    @Override
    public void saveClientList() {

    }

    @Override
    public void saveATMList() {

    }
}
