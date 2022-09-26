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
    static Scanner input = new Scanner(System.in);

    public static void welcomeToATM(String atmID, String atmName) {
        System.out.println("Welcome to " + atmName + " ATM Nr:" + atmID);
        cardEntering();

    }


    public static void cardEntering() {

        System.out.println("Enter your card nr");
        String cardNr = input.next();
        if (CardValidator.containsCardNr(cardNr)) {
            System.out.println("Enter card pin");
            int pin = input.nextInt();
            if (CardValidator.containsPin(cardNr, pin)) {
                startOperation(cardNr, pin);
            }
        } else {
            System.out.println("Invalid Card try another");
        }
    }

    private static void startOperation(String cardNr, int pin) {
        HashMap<String, String> neededInfo = filterNeededInfo(cardNr, pin);
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
                //todo :     "2 -> FOR cash deposits\n"
            case 3:
                //todo :    "3 -> FOR withdraw\n"
            case 4:
                //todo :     "4 -> FOR transferring funds\n"

            case 5:
                //todo :      "5 -> ATM PIN change\n"

            case 6:
                //todo :      "6 -> FOR SEEING OTHER TYPES  OF ACCOUNT INFO \n"

            case 0:
            default:
                cardEntering();
                break;
        }
    }

    private static void goback() {
        System.out.println("Do you want to do other operation ? y/n ");
    }

    private static void atmMenu() {
        System.out.println("Press : \n" +
                "1 -> FOR SEEING YOUR ACCOUNT AMOUNT\n" +
                "2 -> FOR cash deposits\n" +
                "3 -> FOR withdraw\n" +
                "4 -> FOR transferring funds\n" +
                "5 -> ATM PIN change\n" +
                "6 -> FOR SEEING OTHER TYPES  OF ACCOUNT INFO \n" +
                "0 -> FOR SEEING YOUR ACCOUNT AMOUNT\n" + " ");
    }

    private static HashMap<String, String> filterNeededInfo(String cardNr, int pin) {
        for (Map.Entry<String, Client> stringClientEntry : Clients.getClientsList().entrySet()) {
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
                    ;
                }
            }
        }
        return null;
    }

    private static String greetings() {
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
