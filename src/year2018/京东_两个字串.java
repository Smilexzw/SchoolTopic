package year2018;

import java.util.Scanner;

/**
 * 题目描述
 * 给定一个字符串s, 请计算输出含有连续两个s作为子串的最短字符串。 注意两个s可能有重叠部分。例如,"ababa"含有两个"aba".
 * 输入描述:
 * 输入包括一个字符串s,字符串长度length(1 ≤ length ≤ 50),s中每个字符都是小写字母.
 * 输出描述:
 * 输出一个字符串,即含有连续两个s作为子串的最短字符串。
 * 示例1
 * 输入
 * 复制
 * abracadabra
 * 输出
 * 复制
 * abracadabracadabra
 *
 * @author: xuzhangwang
 */
public class 京东_两个字串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        StringBuffer res = new StringBuffer(str);
        char[] c = str.toCharArray();
        int fast = 0;
        int slow = 0;
        for (int k = 1; k < c.length; k++) {
            fast = k;
            slow = 0;
            while (c[slow] == c[fast]) {
                slow++;
                fast++;
                // 如果fast走到了最后
                if (fast == c.length) {
                    while (slow < c.length) {
                        res.append(c[slow++]);
                    }
                    break;
                }
            }

            if (res.length() > c.length) {
                break;
            }

            if ((fast == c.length - 1) && (slow == 0)) {
                res.append(str);
                break;
            }
        }

        System.out.println(res.toString());
    }
}
