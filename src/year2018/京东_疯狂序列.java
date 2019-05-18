package year2018;

import java.util.Scanner;

/**
 * 东东从京京那里了解到有一个无限长的数字序列: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, ...(数字k在该序列中正好出现k次)。东东想知道这个数字序列的第n项是多少,你能帮帮他么
 * 输入描述:
 * 输入包括一个整数n(1 ≤ n ≤ 10^18)
 * 输出描述:
 * 输出一个整数,即数字序列的第n项
 * 示例1
 * 输入
 * 复制
 * 169
 * 输出
 * 复制
 * 18
 *
 * @author: xuzhangwang
 */
public class 京东_疯狂序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        // 等差数列, 直接判断
        long t = (long) Math.sqrt(2 * n);
        long temp = ((t + 1) * t) / 2;
        if (temp < n) {
            System.out.println(t + 1);
        } else {
            System.out.println(t);
        }

    }
}
