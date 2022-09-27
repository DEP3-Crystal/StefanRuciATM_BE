package org.crystal.atm.io.output;

import org.crystal.atm.dao.ATMs;
import org.crystal.atm.dao.Clients;
import org.crystal.atm.io.DataOrigin;

public abstract class DataOutput extends DataOrigin {
    protected DataOutput(Clients clients, ATMs atmS) {
        super(clients, atmS);
    }

    protected DataOutput(ATMs atmS) {
        super(atmS);
    }

    protected DataOutput(Clients clients) {
        super(clients);
    }

    public abstract void saveClientList();
    public abstract void saveATMList();
}
