package year2018;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 网易_骰子游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();

        if (x < n * 1) {
            System.out.println(1);
            return;
        } else if (x > n * 6) {
            System.out.println(0);
            return;
        }

        int count = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (i + j + k >= x) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
        long gcd = gcd(count, (long) Math.pow(6, 3));
        System.out.println(count / gcd + "/" + 216 / gcd);
    }

    public static long gcd(long m, long n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
