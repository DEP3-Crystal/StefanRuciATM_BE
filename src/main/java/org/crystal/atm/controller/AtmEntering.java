package org.crystal.atm.controller;

import org.crystal.atm.dao.BankInfo;
import org.crystal.atm.exeptions.AccountNotFoundEx;
import org.crystal.atm.exeptions.IncorrectInputEx;
import org.crystal.atm.exeptions.InsufficientBalanceEx;
import org.crystal.atm.exeptions.NegativeInputEx;
import org.crystal.atm.model.ATM;
import org.crystal.atm.services.ATMBankService;
import org.crystal.atm.services.ATMClientService;

import java.util.Scanner;

public class AtmEntering {
    private ATMClientService atmClientService;
    private ATMBankService atmBankService;

    public AtmEntering() throws AccountNotFoundEx, InsufficientBalanceEx, IncorrectInputEx, NegativeInputEx {
        BankInfo bankInfo=new BankInfo();
        this.atmClientService = new ATMClientService(bankInfo);
        this.atmBankService = new ATMBankService(bankInfo);
        menu();
    }

    public  void menu() throws AccountNotFoundEx, InsufficientBalanceEx, IncorrectInputEx, NegativeInputEx {
         final Scanner input = new Scanner(System.in);
            ATM atm=atmBankService.getRandomAtm();
        System.out.println("Welcome to ATM Nr:" + atm.getAtmNr());

        System.out.println("Enter a number : \n1-> Enter as Admin \n2-> Enter as Client \n0->Exit \nPress one number : ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                ATMAdminController atmAdminController = new ATMAdminController(atmBankService);
                atmAdminController.mainMenu(atm.getAtmNr(), atm.getAddress());
                break;
            case 2:
                ATMClientCardInput atmClientCardInput = new ATMClientCardInput(atmClientService);
                atmClientCardInput.mainMenu(atm.getAtmNr(), atm.getAddress());
                break;
            case 0:
            case default:
                System.out.println("Wrong choice!");
               menu();
        }
    }

}
