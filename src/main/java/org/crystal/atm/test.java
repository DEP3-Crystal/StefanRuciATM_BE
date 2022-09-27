package org.crystal.atm;

import org.crystal.atm.dao.Clients;
import org.crystal.atm.io.input.DataInput;
import org.crystal.atm.io.input.from_db.ReadDataFromDb;
import org.crystal.atm.model.CardDetails;
import org.joda.time.DateTimeZone;

import java.util.*;


public class test {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(((new Random().nextInt(1001, 9999))));
//        }
        org.joda.time.format.DateTimeFormatter dtf = org.joda.time.format.DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
        org.joda.time.LocalDateTime ldt = dtf.parseLocalDateTime("2014-12-25 12:23:34.567");
        System.out.println(ldt);

        long delta = ldt.toDateTime().getMillis();
        System.out.println(delta);

        java.util.Date dt = new java.util.Date(delta);
        System.out.println(dt);
        DateTimeZone utc = DateTimeZone.UTC;

//        System.out.println(now(DateTimeZone.forOffsetHours(+2)));
        String cardNr = "4441 1122 2555 5555";
        final List<CardDetails>[] cardDetailsList = new List[]{new ArrayList<>()};
        DataInput dataInput = new ReadDataFromDb(new Clients());
        System.out.println(dataInput.getCardDetailerFor("4445 4555 5544 6556", 4578));

//        string.replace(newString);
    }

}
