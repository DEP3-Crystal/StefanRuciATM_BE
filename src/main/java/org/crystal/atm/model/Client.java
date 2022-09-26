package org.crystal.atm.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class Client {

    private  String ID;
    private String name;
    private String surName;
    private String fullName;
    private char gender;
    private int age;
    private String birthday;
private List<ClientContactInfo> clientContactInfoList =new ArrayList<>();
private Map<String,ClientAccountDetails>  clientAccountDetailsList=new HashMap<>();
    public Client(){

    }

    public Client(String ID, String name, String surName, String fullName, char gender, int age, String birthday, List<ClientContactInfo> clientContactInfoList, Map<String, ClientAccountDetails> clientAccountDetailsList) {
        this.ID = ID;
        this.name = name;
        this.surName = surName;
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.clientContactInfoList = clientContactInfoList;
        this.clientAccountDetailsList = clientAccountDetailsList;
    }
}
