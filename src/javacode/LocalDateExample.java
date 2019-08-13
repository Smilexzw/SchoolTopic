package javacode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author xuzhangwang
 * @date 2019/7/25
 */
public class LocalDateExample {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        System.out.println("今天的日期" + today);
        LocalDateTime tomorrow = today.plus(1, ChronoUnit.DAYS);
        System.out.println("明天的日期" + tomorrow);


        String patern = "yyyy/MM/dd HH:mm:SS";
        String date = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(today);
        System.out.println(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patern);
        System.out.println(formatter.format(today));
    }
}
