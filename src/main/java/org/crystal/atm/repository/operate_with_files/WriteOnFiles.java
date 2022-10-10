package org.crystal.atm.repository.operate_with_files;

import org.crystal.atm.dao.BankInfo;

public class WriteOnFiles  extends FileAccess {


    protected WriteOnFiles(BankInfo bankInfo) {
        super(bankInfo);
    }

    @Override
    public void saveClientList() {

    }

    @Override
    public void saveATMList() {

    }
//
//    //how to write in file without deleting contente in java?
//    FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
//    //^^^^ means append
////how to write data  in file in java?
//PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
//writer.println("The first line");
//writer.println("The second line");
//writer.close();
//
//
//byte data[] = ...
//FileOutputStream out = new FileOutputStream("the-file-name");
//out.write(data);
//out.close();
//
//
//List<String> lines = Arrays.asList("The first line", "The second line");
//Path file = Paths.get("the-file-name.txt");
//Files.write(file, lines, StandardCharsets.UTF_8);
////Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
//
//
//byte data[] = ...
//Path file = Paths.get("the-file-name");
//Files.write(file, data);
////Files.write(file, data, StandardOpenOption.APPEND);
}
