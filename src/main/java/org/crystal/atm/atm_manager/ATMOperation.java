package org.crystal.atm.atm_manager;

import org.crystal.atm.model.ClientAccountDetails;

public class ATMOperation {

    public void withdraw(double sumOfWithdraw, ClientAccountDetails clientAccountDetails) {
        if (sumOfWithdraw < clientAccountDetails.getAmount()) {
            clientAccountDetails.setAmount(clientAccountDetails.getAmount()-sumOfWithdraw);
            System.out.println("transaction Done");
        }
    }
}
