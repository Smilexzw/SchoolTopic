package year2018;

import java.util.Scanner;

/**
 * 时间限制：1秒 空间限制：32768K 热度指数：69998
 * 算法知识视频讲解
 * 校招时部分企业笔试将禁止编程题跳出页面，为提前适应，练习时请使用在线自测，而非本地IDE。
 * 题目描述
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 * 输入描述:
 * 无序整数数组A[n]
 * 输出描述:
 * 满足条件的最大乘积
 * 示例1
 * 输入
 * 复制
 * 3 4 1 2
 * 输出
 * 复制
 * 24
 * <p>
 * <p>
 * <p>
 * 思路设置五个变量，最大， 次大， 第三大
 * 最小， 次小
 * 最大乘机的只能为max1 * max2 * max3  或则  max1 * max4 * max 5;
 *
 * @author: xuzhangwang
 */
public class 拼多多_最大乘机 {
    public static void main(String[] args) {
        int max1, max2, max3;
        int min1, min2;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        min1 = min2 = Integer.MAX_VALUE;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            // 1、当前的数字最小
            if (t < min1) {
                min2 = min1;
                min1 = t;
            } else if (t < min2) {
                min2 = t;
            }

            // 2、当前的数字最大
            if (t > max1) {
                max3 = max2;
                max2 = max1;
                max1 = t;
            } else if (t > max2) {
                max3 = max2;
                max2 = t;
            } else if (t > max3) {
                max3 = t;
            }
        }
        long res = Math.max((long) max1 * max2 * max3, (long) max1 * min1 * min2);
        System.out.println(res);
    }
}
