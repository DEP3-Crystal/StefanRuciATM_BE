package org.crystal.atm.io;

import org.crystal.atm.dao.ATMs;
import org.crystal.atm.dao.Clients;

public class ReadDataFromFiles extends DataInput{

    public ReadDataFromFiles(Clients clients , ATMs atmS) {
        super(clients,atmS);
    }
    public ReadDataFromFiles(ATMs atmS) {
        super(atmS);
    }
    public ReadDataFromFiles(Clients clients ) {
        super(clients);
    }

    @Override
    public void setClientList() {

    }

    @Override
    public void setATMList() {

    }

}
