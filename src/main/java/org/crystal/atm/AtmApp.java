package org.crystal.atm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.crystal.atm.dao.Clients;
import org.crystal.atm.model.Address;
import org.crystal.atm.model.Client;
import org.crystal.atm.model.ClientAccountDetails;
import org.crystal.atm.model.ClientContactInfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.crystal.atm.controller.ATMController.genIBAN;
import static org.crystal.atm.controller.ATMController.genId;

public class AtmApp {
    public static void main(String[] args) throws JsonProcessingException {

//        System.out.println(app.registerAnAccount(UUID.randomUUID().toString()));
        System.out.println("ID");
        System.out.println(genId());

        System.out.println("IBAN");
        System.out.println(genIBAN("AL", String.valueOf(genId()), String.valueOf(genId())));
        System.out.println(genIBAN("AL", String.valueOf(genId()), String.valueOf(genId())).length());

        System.out.println("AL35202111090000000001234567".length());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Clients clients = new Clients();
        Client client1 = new Client();
        Client client2 = new Client();

        client1.setID("00001");
        client1.setBirthday("bday");
        client1.setAge(18);
        client1.setGender('m');
        client1.setName("name1");
        client1.setFullName("fullName1");
        client1.setSurName("surname1");
        client1.getClientAccountDetailsList().put("TorsosDSP",
                new ClientAccountDetails("AC000055515201",
                        999999955,
                        new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date())
                        , "Debit")
        );
        client2.getClientContactInfoList().add(
                new ClientContactInfo(
                        new ArrayList<>(List.of("sr@dsd.eu")),
                        new ArrayList<>(List.of("0625554455")),
                        new ArrayList<>(List.of(
                                new Address("Al", "Dr", "Lgj.nr1"))
                        )
                )
        );

        client2.setID("00002");
        client2.setBirthday("bday");
        client2.setAge(18);
        client2.setGender('m');
        client2.setName("name1");
        client2.setFullName("fullName1");
        client2.setSurName("surname1");
        client2.getClientAccountDetailsList().put("s222s2s2d2sad2s", new ClientAccountDetails("AC000055515201", 999999955, formatter.format(date), "Debit"));
        client2.getClientContactInfoList().add(new ClientContactInfo(new ArrayList<>(Arrays.asList("sr@dsd.eu")), new ArrayList<>(Arrays.asList("0625554455")), new ArrayList<>(Arrays.asList(new Address("al", "dr", "lgj.nr1")))));
        clients.getClientsList().put(client1.getID(), client1);
        clients.getClientsList().put(client2.getID(), client2);
        System.out.println(clients.getClientsList());
//        contains(clients.getClientsList().get(0),"bday");
        clients.getClientsList().forEach((k, v) -> {
            System.out.println("Key : " + k + " Value : " + v + "\n");
        });
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(clients.getClientsList());
        System.out.println(json);
    }

    public static String contains(Client client, String tofind) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(client);
        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.readValue(json, ObjectNode.class);

        if (node.has("birthday")) {
            System.out.println("birthday: " + node.get("birthday"));
        }
        return " ";
    }
}

