package offer;

import java.util.Scanner;

/**
 * @author xuzhangwang
 */
public class 把字符串转换为整数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Integer res = Integer.valueOf(str);
        System.out.println(res);
    }


    /**
     * 不使用java库中的函数
     * @param str
     * @return
     */
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        boolean isFushu = str.charAt(0) == '-';
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) continue;
            if (c > '9' || c < '0') return 0;
            res = res * 10 + (c - '0');
        }
        return isFushu ? -res : res;
    }
}
