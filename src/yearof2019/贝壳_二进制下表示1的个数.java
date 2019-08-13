package yearof2019;

import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/8/10
 */
public class 贝壳_二进制下表示1的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int sum = (int) (Math.pow(2, a) + Math.pow(2, b) - Math.pow(2, c));
        System.out.println(sum);
        System.out.println(Integer.toBinaryString(sum));

        char[] chs = Integer.toBinaryString(sum).toCharArray();
        int res = 0;
        for (char ch : chs) {
            if (ch == '1') {
                res++;
            }
        }
        System.out.println("结果：" + res);
    }
}
