package org.crystal.atm.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class ClientContactInfo{
    private List<String> emailList =new ArrayList<>();
    private List<String> phoneNumberList =new ArrayList<>();
       private List<Address> addressList =new ArrayList<>();

    public ClientContactInfo(){

    };

    public ClientContactInfo(List<String> emailList, List<String> phoneNumberList, List<Address> addressList) {
        this.emailList = emailList;
        this.phoneNumberList = phoneNumberList;
        this.addressList = addressList;
    }
}
