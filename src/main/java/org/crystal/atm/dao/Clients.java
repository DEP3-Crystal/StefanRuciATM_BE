package org.crystal.atm.dao;

import lombok.Data;
import org.crystal.atm.model.Client;

import java.util.HashMap;
import java.util.Map;

@Data
public class Clients {
    private  Map<String, Client> clientsList = new HashMap<>();

    public  Map<String, Client> getClientsList() {
        return clientsList;
    }


}
