package org.crystal.atm.dao;

import lombok.Data;
import org.crystal.atm.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class BankInfo {


    private List< Client> clientsList = new ArrayList<>();
    private List<AccountDetails> accountDetailsList = new ArrayList<>();
    private List<CardDetails> cardList = new ArrayList<>();
    private List<Transaction> transactionList = new ArrayList<>();
    private List<ATM> atmList = new ArrayList<>();

public void setAtmList(){
    atmList.add(new ATM("0001","AL","DR","Route Nr.41", (float) 95.22, (float) 45.984,new BigDecimal(5000000)));
    atmList.add(new ATM("0002","AL","DR","Route Nr.49", (float) 99.22, (float) 44.984,new BigDecimal(4000000)));
    }
}
