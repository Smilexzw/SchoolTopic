package yearof2017;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 题目描述
 * 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 * 输入描述:
 * 输入数据有多组，每组占一行，由两个整数n（n < 10000）和m(m < 1000)组成，n和m的含义如前所述。
 */
public class 挖财_求数列的和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            valid(n, m);
        }
    }

    private static void valid(int n, int m) {
        double res = 0;
        double d = n;
        while (m != 0) {
            res += d;
            d = Math.sqrt(d);
            m--;
        }
        System.out.println(String.format("%.2f", res));
    }
}
