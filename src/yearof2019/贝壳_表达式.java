package yearof2019;

import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/8/10
 */
public class 贝壳_表达式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int max = Integer.MIN_VALUE;
        if (true) {
            int t = a + (b * c);
            max = Math.max(max, t);

            t = a * (b + c);
            max = Math.max(max, t);

            t = a * b * c;
            max = Math.max(max, t);

            t = (a + b) * c;
            max = Math.max(max, t);
        }

        System.out.println(max);
    }
}
