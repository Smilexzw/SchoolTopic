package code;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 格式化输出 {
    public static void main(String[] args) {
        double grade = 89.89989;
        System.out.println(String.format("%.3f", grade));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean res = isOdd(n);
        System.out.println(res);
    }

    private static boolean isOdd(int n) {
        return Math.abs(n % 2)  == 1;
    }
}
