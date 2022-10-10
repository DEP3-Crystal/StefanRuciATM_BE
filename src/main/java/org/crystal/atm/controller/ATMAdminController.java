package org.crystal.atm.controller;

import org.crystal.atm.services.ATMBankService;

import java.util.Random;

public class ATMAdminController extends AtmController {


    public ATMAdminController(ATMBankService atmBankService) {
        super(atmBankService);
    }

    @Override
    public void mainMenu(String atmID, String atmName) {

    }


    public static String genIBAN(String contryCode, String costumerId, String accountNumber) {
        Random random = new Random();
        return contryCode + "4800" + costumerId + accountNumber + random.nextInt(100000, 999999);
    }

    public static int genId() {
        Random random = new Random();
        return random.nextInt(10000000, 99999999);
    }


}
