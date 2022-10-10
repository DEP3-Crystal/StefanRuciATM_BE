package org.crystal.atm;

import org.crystal.atm.controller.AtmEntering;
import org.crystal.atm.exeptions.AccountNotFoundEx;
import org.crystal.atm.exeptions.IncorrectInputEx;
import org.crystal.atm.exeptions.InsufficientBalanceEx;
import org.crystal.atm.exeptions.NegativeInputEx;

public class AtmApp {
    public static void main(String[] args) throws AccountNotFoundEx, InsufficientBalanceEx, IncorrectInputEx, NegativeInputEx {
        AtmEntering atmEntering=new AtmEntering();
    }

}

