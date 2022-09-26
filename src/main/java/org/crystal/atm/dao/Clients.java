package org.crystal.atm.dao;

import lombok.Data;
import org.crystal.atm.model.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Clients {

    public static Map<String, Client> getClientsList() {
        return clientsList;
    }

    private static Map<String, Client> clientsList = new HashMap<>();

    public static List<Client> getAll() {
        return new ArrayList<>(clientsList.values());
    }

    public static void save(Client client) {

    }

    public static void update(Client client, String[] params) {

    }

    public static void delete(Client client) {
    }

}
