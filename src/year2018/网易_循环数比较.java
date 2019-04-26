package year2018;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 网易_循环数比较 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x1 = sc.next();
        String x2 = sc.next();
        String x3 = sc.next();
        String x4 = sc.next();

        String res = helper(x1, x2, x3, x4);
        System.out.println(res);
    }

    private static String helper(String x1, String x2, String x3, String x4) {
        String a = "";
        String b = "";
        for (int i = 0; i < Integer.valueOf(x2); i++) {
            a += x1;
        }
        for (int i = 0; i < Integer.valueOf(x4); i++) {
            b += x3;
        }
        BigDecimal x = new BigDecimal(a);
        BigDecimal y = new BigDecimal(b);
        double res = x.subtract(y).doubleValue();
        if (res == 0) {
            return "Equal";
        } else if (res > 0) {
            return "Greater";
        } else {
            return "Less";
        }
    }


}
