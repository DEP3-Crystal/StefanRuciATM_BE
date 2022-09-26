package org.crystal.atm;

import org.joda.time.DateTimeZone;

import java.util.Random;

import static org.joda.time.LocalDateTime.now;


public class test {
    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(((new Random().nextInt(1001, 9999))));
//        }

        System.out.println(now(DateTimeZone.forOffsetHours(+1)));

//        astring.replace(newString);
    }
}
