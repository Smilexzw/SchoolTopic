package year2018;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 拼多多_大整数相乘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int[] s = new int[a.length() + b.length()];

        for (int i = a.length() - 1; i >= 0; i--) {
            int x = a.charAt(i) - '0';
            for (int j = b.length() - 1; j >= 0; j--) {
                int y = b.charAt(j) - '0';
                s[i + j] += (s[i + j + 1] + x * y) / 10;
                s[i + j + 1] = (s[i + j + 1] + x * y) % 10;
            }
        }

        int index = 0;
        String res = "";
        for (int i = 0; i < s.length; i++) {
            if (s[i] != 0) {
                index = i;
                break;
            }
        }
        for (int i = index; i < s.length; i++) {
            res += s[i];
        }
        System.out.println(res);
    }
}
