package chapter04;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Title: N皇后问题
 * @Description: N皇后问题是指在N*N的期盼上要摆N个皇后，要求任何两个皇后不同行，不同列，也不在同一条的写线上。
 * 指定一个整数n，返回n皇后的摆法有多少种。
 */
public class Chapter04_NQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = num1(n);
        System.out.println(result);
    }

    private static int num1(int n) {
        if (n < 1) return 0;
        int[] record = new int[n];
        return process1(0, record, n);
    }

    private static int process1(int i, int[] record, int n) {
        if (i == n) return 1;
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }
}
