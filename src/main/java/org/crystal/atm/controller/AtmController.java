package org.crystal.atm.controller;

import lombok.Data;
import org.crystal.atm.exeptions.AccountNotFoundEx;
import org.crystal.atm.exeptions.IncorrectInputEx;
import org.crystal.atm.exeptions.InsufficientBalanceEx;
import org.crystal.atm.exeptions.NegativeInputEx;
import org.crystal.atm.model.ATM;
import org.crystal.atm.services.ATMBankService;
import org.crystal.atm.services.ATMClientService;

import java.util.Scanner;
@Data
public abstract class AtmController {
    protected final Scanner input = new Scanner(System.in);
    private ATMClientService atmClientService;
    private ATMBankService atmBankService;

    public AtmController(ATMClientService atmClientService) {
        this.atmClientService = atmClientService;
    }

    public AtmController(ATMBankService atmBankService) {
        this.atmBankService = atmBankService;
    }


     abstract void mainMenu(String atmID, String atmName) throws AccountNotFoundEx, InsufficientBalanceEx, IncorrectInputEx, NegativeInputEx;

    }


