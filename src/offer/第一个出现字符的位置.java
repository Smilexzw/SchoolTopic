package offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 第一个出现字符的位置 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int res = FirstNotRepeatingChar(str);
        System.out.println(res);
    }

    public static int FirstNotRepeatingChar(String str) {

        char[] c = str.toCharArray();
        int[] a = new int['z' + 1];

        for (int i = 0; i < c.length; i++) {
            a[c[i]]++;
        }

        for (int i = 0; i < c.length; i++) {
            if (a[c[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
