package org.crystal.atm.exeptions;

public class InsufficientBalanceEx extends Exception{
    public InsufficientBalanceEx(String message){
        super(message);
    }

}
