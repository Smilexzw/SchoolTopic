package leetcode;

/**
 * @author: xuzhangwang
 */
public class _043字符串相乘 {
    public static void main(String[] args) {
        String res = multiply("0", "0");
        System.out.println(res);
    }

    public static String multiply(String a, String b) {

        int[] s = new int[a.length() + b.length()];
        for (int i = a.length() - 1; i >= 0; i--) {
            int x = a.charAt(i) - '0';
            for (int j = b.length() - 1; j >= 0; j--) {
                int y = b.charAt(j) - '0';
                s[i + j] += (s[i + j + 1] + x * y) / 10;
                // 剩余的
                s[i + j + 1] = (s[i + j + 1] + x * y) % 10;
            }
        }

        String res = "";
        int i = 0;
        while (i < s.length - 1 && s[i] == 0) {
            i++;
        }

        for ( ; i < s.length; i++) {
            res += s[i];
        }
        return res;
    }
}
