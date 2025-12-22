package Buoi_03.Bai_3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class LocalDateUtil {
    private static final DateTimeFormatter F_DDMMYYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter F_YYYYMMDD = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    private LocalDateUtil() {}

    public static LocalDate fromString_ddMMyyyy(String date) {
        return LocalDate.parse(date, F_DDMMYYYY);
    }

    public static LocalDate fromString_yyyyMMdd(String date) {
        return LocalDate.parse(date, F_YYYYMMDD);
    }

    public static String toString_ddMMyyyy(LocalDate date) {
        return date.format(F_DDMMYYYY);
    }

    public static String toString_yyyyMMdd(LocalDate date) {
        return date.format(F_YYYYMMDD);
    }
}
