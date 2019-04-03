package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 12. 整数转罗马数字
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论
 * 题解
 * 提交记录
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class _012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String s = intToRoman(num);
        System.out.println(s);
    }

    public static String intToRoman(int num) {
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        StringBuffer sb = new StringBuffer();
        while (num != 0) {
            if (num >= 1000) {
                int qianwei = num / 1000;
                for (int i = 0; i < qianwei; i++) {
                    sb.append("M");
                }
                num %= 1000;
            }
            // 处理100~1000的数字
            if (num >= 100 && num < 1000) {
                int baiwei = num / 100;
                if (baiwei < 4) {
                    for (int i = 0; i < baiwei; i++) {
                        sb.append("C");
                    }
                } else if (baiwei >= 4 && baiwei < 5) {
                    sb.append("CD");
                } else if (baiwei >= 5 && baiwei < 9) {
                    sb.append("D");
                    baiwei -= 5;
                    for (int i = 0; i < baiwei; i++) {
                        sb.append("C");
                    }
                } else {
                    sb.append("CM");
                }
                num %= 100;
            }


            // 处理10~100的数字
            if (num >= 10 && num < 100) {
                int shiwei = num / 10;
                if (shiwei < 4) {
                    for (int i = 0; i < shiwei; i++) {
                        sb.append("X");
                    }
                } else if (shiwei >= 4 && shiwei < 5) {
                    sb.append("XL");
                } else if (shiwei >= 5 && shiwei < 9) {
                    sb.append("L");
                    shiwei -= 5;
                    for (int i = 0; i < shiwei; i++) {
                        sb.append("X");
                    }
                } else {
                    sb.append("XC");
                }
                num %= 10;
            }

            // 处理1~10的数字
            if (num >= 1 && num < 10) {
                int gewei = num;
                if (gewei < 4) {
                    for (int i = 0; i < gewei; i++) {
                        sb.append("I");
                    }
                } else if (gewei >= 4 && gewei < 5) {
                    sb.append("IV");
                } else if (gewei >= 5 && gewei < 9) {
                    sb.append("V");
                    gewei -= 5;
                    for (int i = 0; i < gewei; i++) {
                        sb.append("I");
                    }
                } else {
                    sb.append("IX");
                }
                num /= 10;
            }

        }

        return sb.toString();
    }
}
