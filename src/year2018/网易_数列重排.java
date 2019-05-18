package year2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 牛牛有一个正整数x,牛牛需要把数字x中的数位进行重排得到一个新数(不同于x的数),牛牛想知道这个新数是否可能是原x的倍数。请你来帮他解决这个问题。
 * 输入描述:
 * 输入包括t+1行,第一行包括一个整数t(1 ≤ t ≤ 10),
 * 接下来t行,每行一个整数x(1 ≤ x ≤ 10^6)
 * 输出描述:
 * 对于每个x,如果可能重排之后变为自己的倍数输出"Possible", 否则输出"Impossible".
 * 示例1
 * 输入
 * 复制
 * 2
 * 14
 * 1035
 * 输出
 * 复制
 * Impossible
 * Possible
 *
 * @author: xuzhangwang
 */
public class 网易_数列重排 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            // 要求倍数但是要数位相同
            boolean flag = false;
            for (int j = 2; j <= 9; j++) {
                int y = x * j;
                if (equal(x, y)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }



    }

    private static boolean equal(int x, int y) {
        String a = String.valueOf(x);
        String b = String.valueOf(y);

        if (a.length() != b.length()) {
            return false;
        }

        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(s2);

        for (int i = 0; i < a.length(); i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }

        return true;

    }


}

