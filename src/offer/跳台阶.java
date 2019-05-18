package offer;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 跳台阶 {
    public static void main(String[] args) {
//
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(JumpFloor1(n));
        System.out.println(JumpFloor(n));
    }

    /**
     * 跳台阶，一次可以向上跳跃一次，可以一次向上跳两个
     *
     * @param target
     * @return
     */
    public static int JumpFloor(int target) {
        if (target <= 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    /**
     * 使用迭代的方法相当与斐波那契数列的变形
     * f(1) = 1;
     * f(2) = 2;
     * f(3) = 3;
     * f(4) = 5;
     * f(5) = 8;
     */
    public static int JumpFloor1(int target) {
        if (target <= 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int res = 2;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= target; i++) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }

}
