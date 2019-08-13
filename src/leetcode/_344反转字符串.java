package leetcode;

import java.util.Arrays;

/**
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _344反转字符串 {

    public static void main(String[] args) {
        char[] s = "Hannah".toCharArray();
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char t = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = t;
        }
        System.out.println(Arrays.toString(s));
    }
}
