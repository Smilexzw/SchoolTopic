package chapter09;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 一行代码求两个数的最大公约数
 * 给定两个不等于0的正数M和N，求M和N的最大公约数
 */
public class Cahpter09_gcd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int tmp = gcd(m, n);
        System.out.println(tmp);
    }

    /**
     * 一个简单的方法，求两个数的最大公约数的算法在欧几里得的《几何原本》中提出的欧几里得算法，又称辗转相除法
     * @param m
     * @param n
     * @return
     */
    public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
