package year2018;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 爱奇艺_回文素数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        int res = 0;
        for (int i = start; i <= end; i++) {
            if (isHui(i) && isSuShu(i)) {
                res++;
            }
        }
        System.out.println(res);
    }

    private static boolean isSuShu(int n) {
        if (n <= 3) {
            return n > 1;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isHui(int x) {
        int n = x;
        int y = 0;
        while (n != 0) {
            int tmp = n % 10;
            n /= 10;
            y = y * 10 + tmp;
        }
        return (x == y) ? true : false;
    }
}
