package org.crystal.atm.dao;

import lombok.Data;
import org.crystal.atm.model.Client;
import org.crystal.atm.model.ClientContactInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class Clients {

    private Map<String, Client> clientsList =new HashMap<>();

}
