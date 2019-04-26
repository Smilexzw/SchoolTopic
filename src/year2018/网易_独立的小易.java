package year2018;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 网易_独立的小易 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int f = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();

        int res = helper(x, f, d, p);
        System.out.println(res);
    }

    /**
     *
     * @param x x为当前一天的房租
     * @param f f为手上已有的水果数目
     * @param d d为手中金钱的总数
     * @param p p为水果的售价
     * @return
     */
    private static int helper(int x, int f, int d, int p) {
        int res = 0;
        if (d / x < f) {
            // 当前果子数目下,但是房钱数目不够
            res = (d / x);
            return res;
        } else {
            res += f;
            d = d - (f * x);
            res += (d / (x + p));
            return res;
        }
    }
}
