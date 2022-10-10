package org.crystal.atm.controller;

import org.crystal.atm.exeptions.AccountNotFoundEx;
import org.crystal.atm.exeptions.IncorrectInputEx;
import org.crystal.atm.exeptions.InsufficientBalanceEx;
import org.crystal.atm.exeptions.NegativeInputEx;
import org.crystal.atm.model.AccountDetails;
import org.crystal.atm.model.CardDetails;
import org.crystal.atm.services.ATMClientService;
import org.joda.time.LocalTime;
import java.math.BigDecimal;
import java.util.Objects;


public class ATMClientCardInput extends AtmController {
    private CardDetails card;
    public ATMClientCardInput(ATMClientService atmClientService) {
        super(atmClientService);
    }

    @Override
    public void mainMenu(String atmID, String atmName) throws AccountNotFoundEx, InsufficientBalanceEx, IncorrectInputEx, NegativeInputEx {
        cardEntering();

    }

    public void cardEntering() throws NegativeInputEx, InsufficientBalanceEx, AccountNotFoundEx, IncorrectInputEx {
        int pin = 0;
        String cardNr = " ";
        do {
            System.out.println("Enter your card nr");
            cardNr = input.next();
            if (getAtmClientService().containsCardNr(cardNr)) {
                System.out.println(greetings()+getAtmClientService().getClientInfoByCardNr(cardNr).getName()+"Enter card pin");
                pin = input.nextInt();
                if (getAtmClientService().containsPin(cardNr, pin)) {
                    System.out.println(greetings() +
                            getAtmClientService().getClientInfoByCardNr(cardNr).getFullName());
                    card = getAtmClientService().getCardWitchcontains(cardNr);
                    startOperation(getAtmClientService().getAccountInfo(getAtmClientService().getCardWitchcontains(cardNr).getAccountNr()));
                }
            } else {
                System.out.println("Invalid Card try another");
            }
        } while (!getAtmClientService().containsPin(cardNr, pin));
    }

    public void atmMenu() {
        System.out.println("""
                Press :\s
                1 -> FOR SEEING YOUR ACCOUNT AMOUNT
                2 -> FOR cash deposits
                3 -> FOR withdraw
                4 -> FOR transferring funds
                5 -> ATM PIN change
                6 -> FOR SEEING OTHER TYPES  OF ACCOUNT INFO\s
                0 -> FOR SEEING YOUR ACCOUNT AMOUNT
                \s""");
    }

    public void startOperation(AccountDetails accountDetails) throws NegativeInputEx, InsufficientBalanceEx, AccountNotFoundEx, IncorrectInputEx {

        atmMenu();
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                displayAccountInfo(accountDetails.getAccountNr());
                goBack(accountDetails);
                break;
            case 2:
                //todo :     "2 -> FOR cash deposits"
                depositOperation(accountDetails);
                goBack(accountDetails);
                break;
            case 3:
                //todo :    "3 -> FOR withdraw"
                withdrawOperation(accountDetails);
                goBack(accountDetails);
                break;
            case 4:
                //todo :     "4 -> FOR transferring funds"
                transferringOperation(accountDetails);
                goBack(accountDetails);
                break;
            case 5:
                //todo :      "5 -> ATM PIN change"
                changePin(accountDetails);
                goBack(accountDetails);
            case 6:
                //todo :      "6 -> FOR SEEING OTHER TYPES  OF ACCOUNT INFO"
                displayMyAccountsInfo(accountDetails);
                break;
            case 0:
            default:
                cardEntering();
                break;
        }
    }

    private void displayMyAccountsInfo(AccountDetails accountDetails) {
        getAtmClientService().getClientAccountList(accountDetails.getClientId()).forEach(System.out::println);
    }

    private void changePin(AccountDetails accountDetails) throws IncorrectInputEx {
        System.out.println("Enter new pin");
        int newPin = input.nextInt();
        getAtmClientService().changeAccPin(card, newPin);
    }


    public void depositOperation(AccountDetails accountDetails) throws NegativeInputEx {
        System.out.println("how much you want to deposit?");
        BigDecimal amount = new BigDecimal(input.next());
        if (amount.compareTo(BigDecimal.valueOf(0)) > 0) {
            getAtmClientService().deposit(accountDetails, new BigDecimal(input.next()));
        } else throw new NegativeInputEx("Negative input try again");
    }

    public void withdrawOperation(AccountDetails accountDetails) throws InsufficientBalanceEx, NegativeInputEx {
        System.out.println("how much you want to withdraw?");
        BigDecimal amount = new BigDecimal(input.next());
        if (amount.compareTo(BigDecimal.valueOf(0)) > 0) {
            getAtmClientService().withdraw(accountDetails, new BigDecimal(input.next()));
        } else throw new NegativeInputEx("Negative input try again");
    }

    private void transferringOperation(AccountDetails accountDetails) throws AccountNotFoundEx, NegativeInputEx, InsufficientBalanceEx {
        System.out.println("Enter how much you want to transfer :");
        BigDecimal amount = new BigDecimal(input.next());
        if (amount.compareTo(BigDecimal.valueOf(0)) > 0) {
            char choice;
            do {
                System.out.println("Do you want to transfer by IBAN or Account number ?Pres i/a I/A");
                choice = input.next().toLowerCase().charAt(0);
                if (choice == 'i') {
                    transferringOperationByIban(accountDetails, amount);
                } else if (choice == 'a') {
                    transferringOperationByAccNr(accountDetails, amount);

                } else System.out.println("Enter e valid character");
            } while ((choice != 'a') && (choice != 'i'));
        } else throw new NegativeInputEx("Negative input try again");
    }

    private void transferringOperationByIban(AccountDetails accountDetails, BigDecimal amount) throws AccountNotFoundEx, InsufficientBalanceEx {

        System.out.println("Enter Iban Number");
        String iban = input.next();
        if (getAtmClientService().ibanExist(iban) && !Objects.equals(iban, accountDetails.getIBAN())) {
            if (getAtmClientService().withdraw(accountDetails, amount)) {
                getAtmClientService().deposit(getAtmClientService().getAccountInfoByIBAN(iban), amount);
            }
        } else throw new AccountNotFoundEx("acc not found");
    }

    private void transferringOperationByAccNr(AccountDetails accountDetails, BigDecimal amount) throws AccountNotFoundEx, InsufficientBalanceEx {

        System.out.println("Enter receiver Account Number");
        String receiverAcc = input.next();
        if (getAtmClientService().getAccountInfo(receiverAcc) != null && !Objects.equals(receiverAcc, accountDetails.getAccountNr())) {
            if (getAtmClientService().withdraw(accountDetails, amount)) {
                getAtmClientService().deposit(getAtmClientService().getAccountInfo(receiverAcc), amount);
                System.out.println("trans  done");
            }
        } else throw new AccountNotFoundEx("acc not found");
    }

    public void goBack(AccountDetails accountDetails) throws NegativeInputEx, InsufficientBalanceEx, AccountNotFoundEx, IncorrectInputEx {
        System.out.println("Do you want to do other operation ? y/n ");
        char go = input.next().toLowerCase().charAt(0);
        if (go == 'y') {
            startOperation(accountDetails);
        }
    }

    public void displayAccountInfo(String accId) {
        System.out.println(getAtmClientService().getAccountInfo(accId).toString());
    }


    private String greetings() {
//        LocalTime morning = new LocalTime(6, 0, 0);
        LocalTime noon = new LocalTime(12, 0, 0);
        LocalTime evening = new LocalTime(18, 0, 0);

//        LocalTime midnight = new LocalTime(0, 0, 0);
        if (LocalTime.now().isBefore(noon)) {
            return "Good Morning";
        } else if (LocalTime.now().isBefore(evening)) {
            return "Good Afternoon";
        } else return "Good Evening";
    }
}
