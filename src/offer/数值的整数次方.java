package offer;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 数值的整数次方 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base = sc.nextDouble();
        int exponent = sc.nextInt();

        double res = Power(base, exponent);
        System.out.println(res);
    }


    /**
     * 解题思路
     *
     *
     *        (x * x) ^ (n / 2)     n % 2 == 0
     * x^N =
     *        x * (x * x) ^ (n / 2) n % 2 == 1
     *
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        boolean isFuShu = false;
        if (exponent < 0) {
            exponent = -exponent;
            isFuShu = true;
        }

        double pow = Power(base * base, exponent / 2);
        if (exponent % 2 != 0) {
            pow = pow * base;
        }
        // 判断时候为负数次方
        return isFuShu ? 1 / pow : pow;
    }
}
