package yearof2017;

import java.util.Scanner;

public class 搜狐_彩色宝石项链 {
    public static void main(String[] args) {
        // 模拟环形的项链10, 例如当前位置的 7 + 模拟7个珠子， 那么当前的位置就是14， 14 % 10, 就是第四个珠子
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(invokeLen(sc.nextLine()));
        }
    }

    private static int invokeLen(String s) {
        char[] cha = s.toCharArray();
        int len = s.length();
        // 国王要的珠子最少是5个
        for (int x = 5; x < len; x++) {
            // 从位置0开始寻找
            for (int y = 0; y < len; y++) {
                StringBuffer sb = new StringBuffer();
                for (int z = y; z < x + y; z++) {
                   sb.append(cha[z % len]);
                }
                String tmp = sb.toString();
                if (tmp.contains("A") && tmp .contains("B") && tmp.contains("C") && tmp.contains("D") && tmp.contains("E")) {
                    return len - tmp.length();
                }
            }
        }
        return 0;
    }

}