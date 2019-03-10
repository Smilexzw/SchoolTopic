package chapter09;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 查给定一个非负整数N， 返回N！结果的末尾为0的数量
 */
public class Chapter09_zeroNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int result = zeroNum2(num);
//        System.out.println(result);
        System.out.println("=====================");
        for (int i = 1; i < 20 ; i++) {
            System.out.print(rightOne2  (i) + "\t");
        }
    }

    /**
     * 方法一,看1~N中有多少个含有因子5的个数， 就是最后末尾为0的个数
     * 时间复杂度为NlogN
     * @param num
     * @return
     */
    public static int zeroNum1(int num) {
        if (num < 0) {
            return 0;
        }
        int res = 0;
        int cur = 0;
        for (int i = 5; i < num + 1; i += 5) {
            cur = i;
            while (cur % 5 == 0) {
                res++;
                cur /= 5;
            }
        }
        return res;
    }


    /**
     * Z = N/(5^1) + N/(5^2) + N/(5^3) + ... + N/(5^i) (i一直增长直到5^i大于N)
     * 时间复杂度为LogN
     * @param num
     * @return
     */
    public static int zeroNum2(int num) {
        if (num < 0) {
            return 0;
        }
        int res = 0;
        while (num != 0) {
            res += num / 5;
            num /= 5;
        }
        return res;
    }


    /*
        以下的是进阶的问题
     */
    public static int rightOne1(int num) {
        if (num < 1) {
            return -1;
        }
        int res = 0;
        while (num != 0) {
            num >>>= 1;
            res += num;
        }
        return res;
    }


    /**
     * 此方法需要证明
     */
    public static int rightOne2(int num) {
        if (num < 1) {
            return -1;
        }
        int ones = 0;
        int tmp = num;
        while (tmp != 0) {
            ones += (tmp & 1) != 0 ? 1 : 0;
            tmp >>>= 1;
        }
        return num - ones;
    }
}
