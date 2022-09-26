package org.crystal.atm.controller;

import org.crystal.atm.model.ClientAccountDetails;
import org.crystal.atm.model.Client;

import java.text.SimpleDateFormat;
import java.util.*;

public class ATMController {

    public static Client registerAsClient() {
        Client client = new Client();
        client.setID(UUID.randomUUID().toString());
        String clientID = " ";
        //todo : create registration form for register a client
        registerAnAccount(clientID);
        return client;
    }

    public static ClientAccountDetails registerAnAccount(String clientId) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        ClientAccountDetails clientAccountDetails = new ClientAccountDetails();
        Scanner in = new Scanner(System.in);
        clientAccountDetails.setIBAN("AL" + clientAccountDetails.getId().substring(0, 5) + clientId.substring(0, 5));
        clientAccountDetails.setRegistrationDate(formatter.format(date));
        System.out.println("Set account type : type one of bottom words:\n" +
                "1 -> debit \n2 -> credit\n3 -> deposit  ");
        clientAccountDetails.setType(in.next().toLowerCase(Locale.ROOT));
        //todo : create registration form for register or adding and account details
        return clientAccountDetails;
    }

    public static String genIBAN(String contryCode, String costumerId, String accountNumber) {
        Random random = new Random();
        return contryCode+ "4800" + costumerId + accountNumber + random.nextInt(100000, 999999);
    }

    public static int genId() {
        Random random = new Random();
        return random.nextInt(10000000, 99999999);
    }


}
