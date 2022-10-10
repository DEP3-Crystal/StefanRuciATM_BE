package org.crystal.atm.services;

import org.crystal.atm.dao.BankInfo;
import org.crystal.atm.model.ATM;

import java.util.Random;

public class ATMBankService {
    private BankInfo bankInfo;

    public ATMBankService(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
    }

    public ATM getSpecificAtmInfo(String atmNr) {
        return bankInfo.getAtmList()
                .stream()
                .filter(atm -> atm.getAtmNr().equals(atmNr))
                .toList()
                .get(0);
    }

    public ATM getRandomAtm() {
        Random random = new Random();
        return bankInfo
                .getAtmList()
                .get(random.nextInt(bankInfo.getAtmList().size()));
    }

}
