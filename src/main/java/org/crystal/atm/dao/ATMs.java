package org.crystal.atm.dao;

import lombok.Data;
import org.crystal.atm.model.ATM;

import java.util.HashMap;
import java.util.Map;

@Data
public class ATMs {
    private static Map<String, ATM> atmList = new HashMap<>();

}
