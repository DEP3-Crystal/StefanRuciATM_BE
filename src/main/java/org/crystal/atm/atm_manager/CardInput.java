package org.crystal.atm.atm_manager;


import org.crystal.atm.dao.Clients;
import org.crystal.atm.model.CardDetails;
import org.crystal.atm.model.Client;
import org.crystal.atm.model.ClientAccountDetails;
import org.crystal.atm.validator.CardValidator;
import org.joda.time.LocalTime;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;


public class CardInput {
    private Scanner input = new Scanner(System.in);
    private Clients clients = new Clients();


    public  void welcomeToATM(String atmID, String atmName) {
        System.out.println("Welcome to " + atmName + " ATM Nr:" + atmID);
        cardEntering();

    }


    public  void cardEntering() {

        System.out.println("Enter your card nr");
        String cardNr = input.next();
        if (CardValidator.containsCardNr(cardNr, clients)) {
            System.out.println("Enter card pin");
            int pin = input.nextInt();
            if (CardValidator.containsPin(cardNr, pin, clients)) {
                startOperation(cardNr, pin);
            }
        } else {
            System.out.println("Invalid Card try another");
        }
    }

    private  void startOperation(String cardNr, int pin) {

        HashMap<String, String> neededInfo = filterNeededInfo(cardNr, pin, clients);
        System.out.println(greetings() + neededInfo.get("clientFullName"));
        atmMenu();
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                neededInfo.forEach((key, value) -> System.out.println(key + " : " + value));
                goback();
                char go = input.next().charAt(0);
                if (go == 'y' || go == 'Y') {
                    startOperation(cardNr, pin);
                }
                break;
            case 2:
                //todo :     "2 -> FOR cash deposits"
            case 3:
                //todo :    "3 -> FOR withdraw"
            case 4:
                //todo :     "4 -> FOR transferring funds"

            case 5:
                //todo :      "5 -> ATM PIN change"

            case 6:
                //todo :      "6 -> FOR SEEING OTHER TYPES  OF ACCOUNT INFO"

            case 0:
            default:
                cardEntering();
                break;
        }
    }

    private  void goback() {
        System.out.println("Do you want to do other operation ? y/n ");
    }

    private  void atmMenu() {
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

    private  HashMap<String, String> filterNeededInfo(String cardNr, int pin, Clients clients) {
        for (Map.Entry<String, Client> stringClientEntry : clients.getClientsList().entrySet()) {
            for (Map.Entry<String, ClientAccountDetails> stringClientAccountDetailsEntry : stringClientEntry.getValue().getClientAccountDetailsList().entrySet()) {
                for (CardDetails cardDetails : stringClientAccountDetailsEntry.getValue().getCardList()) {
                    if (Objects.equals(cardDetails.getCardNr(), cardNr) && cardDetails.getCardPin() == pin) {
                        return new HashMap<>(Map.of(
                                "clientId", stringClientEntry.getKey(),
                                "clientFullName", stringClientEntry.getValue().getFullName(),
                                "clientAccountNr", stringClientAccountDetailsEntry.getKey(),
                                "accountAmount", String.valueOf(stringClientAccountDetailsEntry.getValue().getAmount()),
                                "cardNr", cardDetails.getCardNr(),
                                "cardPin", String.valueOf(cardDetails.getCardPin())
                        ));
                    }
                }
            }
        }
        return null;
    }

    private  String greetings() {
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
