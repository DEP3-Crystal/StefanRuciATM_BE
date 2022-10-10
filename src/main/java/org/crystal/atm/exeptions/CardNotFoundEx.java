package org.crystal.atm.exeptions;

public class CardNotFoundEx extends Exception{
    CardNotFoundEx(String message){
        super(message);
    }
}
