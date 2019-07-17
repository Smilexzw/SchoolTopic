package _0702;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author xuzhangwang
 */
public class Main2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            fun(year, month, day);
        }
    }

    private static void fun(int year, int month, int day) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        long end = c.getTimeInMillis();
        Calendar model = Calendar.getInstance();
        model.set(2012, 2, 12);
        long start = model.getTimeInMillis();


        long one = 60 * 60 * 24;
        long time = (end - start) / 1000 + 100;
        long res = time / one;
        System.out.println(res);
    }
}
