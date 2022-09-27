package org.crystal.atm.io.output.to_files;

import org.crystal.atm.dao.ATMs;
import org.crystal.atm.dao.Clients;
import org.crystal.atm.io.output.DataOutput;

public class WriteOnFiles extends DataOutput {

    protected WriteOnFiles(Clients clients, ATMs atmS) {
        super(clients, atmS);
    }

    protected WriteOnFiles(ATMs atmS) {
        super(atmS);
    }

    protected WriteOnFiles(Clients clients) {
        super(clients);
    }

    @Override
    public void saveClientList() {

    }

    @Override
    public void saveATMList() {

    }
}
