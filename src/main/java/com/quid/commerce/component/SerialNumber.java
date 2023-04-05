package com.quid.commerce.component;

import java.time.LocalDate;

public class SerialNumber {
    public static String generate() {
        LocalDate now = LocalDate.now();
        String date = now.toString().replace("-", "");
        return String.format("%s%07d", date, (int) (Math.random() * 10000000));
    }

}
