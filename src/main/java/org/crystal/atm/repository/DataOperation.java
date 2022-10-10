package org.crystal.atm.repository;

import org.crystal.atm.dao.BankInfo;
import org.crystal.atm.model.Client;

import java.util.List;
import java.util.Map;

public abstract class DataOperation {
    protected BankInfo bankInfo;

    protected DataOperation(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
    }
    public abstract void saveClientList();

    public abstract void saveATMList();


    public abstract void setClientList();

    public abstract void setATMList();

    public void getATMList() {

    }
    public List<Client> getClientList() {
        return bankInfo.getClientsList();
    }

}
