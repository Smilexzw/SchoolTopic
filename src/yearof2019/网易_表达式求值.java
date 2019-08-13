package yearof2019;

import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/7/24
 */
public class 网易_表达式求值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c =sc.nextInt();
        int max = Integer.MIN_VALUE;

        if (true) {
            int t = a * b * c;
            if (t > max) {
                max = t;
            }
        }

        if (true) {
            int t = a + b + c;
            if (t > max) {
                max = t;
            }
        }

        if (true) {
            int t1 = a * b + c;
            int t2 = a * (b * c);
            if (t1 < t2) {
                t1 = t2;
            }
            if (t1 > max) {
                max = t1;
            }
        }

        if (true) {
            int t1 = a + b * c;
            int t2 = (a + b) * c;
            if (t1 < t2) {
                t1 = t2;
            }
            if (t1 > max) {
                max = t1;
            }
        }
        System.out.println(max);
    }
}
