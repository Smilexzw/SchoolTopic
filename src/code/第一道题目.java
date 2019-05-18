package code;

import java.util.Scanner;
import java.util.Set;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 第一道题目 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean b = confusingNumber(N);
        System.out.println(b);
    }

    public static boolean confusingNumber(int N) {
        // 0, 1, 6, 8, 9, 是合法的
        // 2, 3, 4, 5, 7  是不合法
        int n = 0;
        int N1 = N;

        while (N != 0) {
            int t = N % 10;
            if (t == 2 || t == 3 || t == 4 || t == 5 || t == 7) return false;
            if (t == 9) {
                n = n * 10 + 6;
                N /= 10;
            } else if (t == 6) {
                n = n * 10 + 9;
                N /= 10;
            } else {
                n = n * 10 + t;
                N /= 10;
            }

        }
        if (n != N1) {
            return true;
        } else return false;
    }
}
