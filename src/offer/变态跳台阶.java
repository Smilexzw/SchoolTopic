package offer;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class 变态跳台阶 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = JumpFloorII1(n);
        System.out.println(res);
    }

    /**
     * +1 为可以直接跳上N台阶
     * 分析 f(1) = 1;
     * f(2) = f(1) + 1;
     * f(3) = f(2) + f(1) + 1;
     * ......
     * f(n)     = f(n - 1) + f(n - 2) +   ..... + f(1) + 1
     * f(n - 1) = f(n - 2) + f(n - 3) + ...+ f(1) + 1
     * f(n) - f(n - 1) = f(n - 1)
     * ==========> f(n) = 2f(n - 1)
     *
     * @param target
     * @return
     */
    public static int JumpFloorII(int target) {
        if (target <= 0) return 0;
        if (target == 1 || target == 2) return target;
        return 2 * JumpFloorII(target - 1);
    }

    public static int JumpFloorII1(int target) {
        if (target <= 0) return 0;
        if (target == 1 || target == 2) return target;
        int res = 2;
        for (int i = 3; i <= target; i++) {
            res = res * 2;
        }
        return res;
    }
}
