package org.crystal.atm.repository.operate_with_files;

import org.crystal.atm.dao.BankInfo;
import org.crystal.atm.repository.DataOperation;

import java.nio.file.Path;

public class FileAccess extends DataOperation {
    private final Path accountListPath = Path.of("src/main/resources/AccountList.csv");
    private final Path addressListPath = Path.of("src/main/resources/AccountList.csv");
    private final Path atmListPath = Path.of("src/main/resources/AccountList.csv");
    private final Path cardListPath = Path.of("src/main/resources/AccountList.csv");
    private final Path clientListPath = Path.of("src/main/resources/AccountList.csv");
    private final Path transListPath = Path.of("src/main/resources/AccountList.csv");


    protected FileAccess(BankInfo bankInfo) {
        super(bankInfo);
    }

    public Path getAccountListPath() {
        return accountListPath;
    }

    public Path getAddressListPath() {
        return addressListPath;
    }

    public Path getAtmListPath() {
        return atmListPath;
    }

    public Path getCardListPath() {
        return cardListPath;
    }

    public Path getClientListPath() {
        return clientListPath;
    }

    public Path getTransListPath() {
        return transListPath;
    }


    @Override
    public void saveClientList() {

    }

    @Override
    public void saveATMList() {

    }

    @Override
    public void setClientList() {

    }

    @Override
    public void setATMList() {

    }
}
