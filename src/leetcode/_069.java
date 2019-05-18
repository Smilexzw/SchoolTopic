package leetcode;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 69. x 的平方根
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (196)
 * 题解
 * 提交记录
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class _069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int res = mySqrt(x);
        System.out.println(res);
    }

    public static int mySqrt(int x) {
        long i = 0;
        long j = x;
        while (i <= j) {
            long mid = (i + j) / 2;
            long s = mid * mid;
            if (s == x) return (int) mid;
            else if (x > s) i = mid + 1;
            else j = mid - 1;
        }
        return (int) j;
    }
}
