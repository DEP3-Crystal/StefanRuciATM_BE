package org.crystal.atm.repository.operate_with_db;

import org.crystal.atm.dao.BankInfo;
import org.crystal.atm.repository.DataOperation;

public abstract class DbAccess extends DataOperation {


    protected DbAccess(BankInfo bankInfo) {
        super(bankInfo);
    }
}
