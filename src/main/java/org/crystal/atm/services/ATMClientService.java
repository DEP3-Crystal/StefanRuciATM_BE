package org.crystal.atm.services;

import lombok.Data;
import org.crystal.atm.dao.BankInfo;
import org.crystal.atm.exeptions.IncorrectInputEx;
import org.crystal.atm.exeptions.InsufficientBalanceEx;
import org.crystal.atm.model.ATM;
import org.crystal.atm.model.AccountDetails;
import org.crystal.atm.model.CardDetails;
import org.crystal.atm.model.Client;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Data
public class ATMClientService {
    private BankInfo bankInfo;

    public ATMClientService(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
        bankInfo.setAtmList();
    }


    public boolean containsPin(String cardNr, int pin) {
        return !bankInfo.getCardList().stream()
                .filter(cardDetails -> Objects.equals(cardDetails.getCardNr(), cardNr) && cardDetails.getCardPin() == pin)
                .toList()
                .isEmpty();

    }

    public boolean containsCardNr(String cardNr) {
        return !bankInfo.getCardList().stream()
                .filter(cardDetails -> Objects.equals(cardDetails.getCardNr(), cardNr))
                .toList()
                .isEmpty();
    }

    public CardDetails getCardWitchcontains(String cardNr) {
        return bankInfo.getCardList()
                .stream()
                .filter(cardDetails -> Objects.equals(cardDetails.getCardNr(), cardNr))
                .toList()
                .get(0);
    }

    public Client getClientInfoByCardNr(String cardNr) {
        return bankInfo.getClientsList()
                .stream()
                .filter(client -> Objects.equals(client.getClientId(), getCardWitchcontains(cardNr).getClientId()))
                .toList()
                .get(0);
    }

    public List<AccountDetails> getClientAccountList(String clientId) {
        return bankInfo.getAccountDetailsList()
                .stream()
                .filter(accountDetails -> accountDetails.getClientId().equals(clientId))
                .toList();
    }

    public boolean withdraw(AccountDetails accountDetails, BigDecimal sumOfWithdraw) throws InsufficientBalanceEx {
        if (sumOfWithdraw.compareTo(accountDetails.getAmount()) > 0) {
            accountDetails.setAmount(accountDetails.getAmount().subtract(sumOfWithdraw));
            System.out.println("transaction Done");
            return true;
        } else {
            throw new InsufficientBalanceEx("Insufficient Balance, Please deposit founds");
        }
    }

    public void deposit(AccountDetails accountDetails, BigDecimal amount) {
        accountDetails.setAmount(accountDetails.getAmount().add(amount));
    }

    public void transfer(String accountId, String receiverAccountId, BigDecimal amount) {

    }


    public AccountDetails getAccountInfo(String accountId) {
        return bankInfo.getAccountDetailsList().stream()
                .filter(accountDetails -> Objects.equals(accountDetails.getAccountNr(), accountId))
                .toList()
                .get(0);
    }
    public AccountDetails getAccountInfoByIBAN(String iban) {
        return bankInfo.getAccountDetailsList().stream()
                .filter(accountDetails -> Objects.equals(accountDetails.getIBAN(), iban))
                .toList()
                .get(0);
    }


    public boolean ibanExist(String iban) {
        return bankInfo.getAccountDetailsList().stream().anyMatch(accountDetails -> Objects.equals(accountDetails.getIBAN(), iban));
    }

    public void changeAccPin(CardDetails card, int newPin) throws IncorrectInputEx {
        card.setCardPin(newPin);
    }
}
