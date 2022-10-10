package org.crystal.atm.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data

public class AccountDetails {
    private String clientId;
    private String accountNr;
    private String IBAN;
    private BigDecimal amount;
    private String registrationDate;
    private String swiftCode;
    private AccountType type;


    public AccountDetails() {
        accountNr = UUID.randomUUID().toString();

    }

    public AccountDetails(String clientId, String accountNr, String IBAN, BigDecimal amount, String registrationDate, String swiftCode, AccountType type) {
        this.clientId = clientId;
        this.accountNr = accountNr;
        this.IBAN = IBAN;
        this.amount = amount;
        this.registrationDate = registrationDate;
        this.swiftCode = swiftCode;
        this.type = type;
    }
}
