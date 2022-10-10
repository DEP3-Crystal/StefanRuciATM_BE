package org.crystal.atm.model;

import lombok.Data;


@Data
public class Client {
    private String clientId;
    private String name;
    private String surName;
    private String fullName;
    private char gender;
    private int age;
    private String birthday;
    private String email;
    private String phoneNumber;
    private String address;

    public Client(String clientId, String name, String surName, String fullName, char gender, int age, String birthday, String email, String phoneNumber, String address) {
        this.clientId = clientId;
        this.name = name;
        this.surName = surName;
        this.fullName = fullName;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Client() {

    }

}
