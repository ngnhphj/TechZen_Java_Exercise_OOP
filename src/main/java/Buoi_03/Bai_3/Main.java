package Buoi_03.Bai_3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String s1 = "22/12/2025";
        LocalDate d1 = LocalDateUtil.fromString_ddMMyyyy(s1);
        System.out.println("Input dd/MM/yyyy: " + s1);
        System.out.println("Parsed LocalDate : " + d1); // ISO: 2025-12-22
        System.out.println();

        String back1 = LocalDateUtil.toString_ddMMyyyy(d1);
        System.out.println("toString_ddMMyyyy: " + back1);
        System.out.println();

        String s2 = "2025/12/22";
        LocalDate d2 = LocalDateUtil.fromString_yyyyMMdd(s2);
        System.out.println("Input yyyy/MM/dd: " + s2);
        System.out.println("Parsed LocalDate : " + d2);
        System.out.println();

        String back2 = LocalDateUtil.toString_yyyyMMdd(d2);
        System.out.println("toString_yyyyMMdd: " + back2);
        System.out.println();

        System.out.println("d1 -> yyyy/MM/dd: " + LocalDateUtil.toString_yyyyMMdd(d1));
        System.out.println("d2 -> dd/MM/yyyy: " + LocalDateUtil.toString_ddMMyyyy(d2));
        System.out.println();

    }
}
