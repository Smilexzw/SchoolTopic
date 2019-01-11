package chapter04;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class Chapter04_斐波那契系列问题的递归和动态问题 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = System.currentTimeMillis();
        int result = f3(n);
        long e = System.currentTimeMillis();
        System.out.println(result);
        System.out.println((e - s) + "ms");

        long start = System.currentTimeMillis();
        int result2 = f1(n);
        long end =  System.currentTimeMillis();
        System.out.println(result2);
        System.out.println((end - start) + "ms");
    }

    public static int f3(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return 1;
        int[][] base = { {1, 1}, {1, 0} };
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    public static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        // 先把res设置为单位矩阵, 相当于整数中的1
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }

        int[][] tmp = m;
        for ( ; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = muliMatrix(res, tmp);
            }
            tmp = muliMatrix(tmp, tmp);
        }
        return res;
    }

    // 实现两个矩阵的相乘
    public static int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

    // 使用递归的方法计算斐波那契数列
    public static int f1(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return 1;
        return f1(n - 1) + f1(n - 2);
    }
}
