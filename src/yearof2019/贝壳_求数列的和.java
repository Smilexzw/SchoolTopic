package yearof2019;

import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/8/10
 */
public class 贝壳_求数列的和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        double res = 0.0;
        double t = n;
        for (int i = 0; i < m; i++) {
            res += t;
            t = Math.sqrt(t);
        }
//        System.out.println(res);
        String format = String.format("%.2f", res);
        System.out.println(format);
    }
}
