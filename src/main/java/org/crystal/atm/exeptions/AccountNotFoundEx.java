package org.crystal.atm.exeptions;

public class AccountNotFoundEx extends Exception{
    public AccountNotFoundEx(String message){
        super(message);
    }
}
