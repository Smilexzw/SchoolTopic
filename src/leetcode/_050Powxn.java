package leetcode;

import java.util.Scanner;

/**
 * 现 pow(x, n) ，即计算 x 的 n 次幂函数。

 示例 1:

 输入: 2.00000, 10
 输出: 1024.00000
 示例 2:

 输入: 2.10000, 3
 输出: 9.26100
 示例 3:

 输入: 2.00000, -2
 输出: 0.25000
 解释: 2-2 = 1/22 = 1/4 = 0.25
 说明:

 -100.0 < x < 100.0
 n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 在真实的面试中遇到过这道题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/powx-n
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xuzhangwang
 * @date 2019/7/29
 */
public class _050Powxn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
        double res = myPow(x, n);
        System.out.println(res);
    }

    public static double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0 ; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return x < 0 ? 1 / res : res;
    }
}
