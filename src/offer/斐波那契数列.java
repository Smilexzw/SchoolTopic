package offer;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 斐波那契数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = Fibonacci1(n);
        System.out.println(res);
    }

    public static int Fibonacci(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static int Fibonacci1(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return 1;
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }
}
