package offer;

import java.util.Scanner;

/**
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 *
 * @author: xuzhangwang
 */
public class 左旋转字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        左旋转字符串 t = new 左旋转字符串();
        String res = t.LeftRotateString(str, 3);
        System.out.println(res);
    }

    public String LeftRotateString(String str, int n) {
        if (str == null) return null;
        int len = str.length();
        if (len == 0) return str;
        n %= len;

        // 开始开始交换
        char[] c = str.toCharArray();
        resever(c, 0, n - 1);
        resever(c, n, len - 1);
        resever(c, 0, len - 1);

        return new String(c);
    }

    /**
     * 有以下的交换， 例如abcXYZdef
     * 第一部分 abc -> cba
     * 第二部分 XYZdef -> fedZYX
     * 第三部分  cbafedZYX -> XYZdefabc
     *
     * @param c
     * @param start
     * @param end
     */
    private void resever(char[] c, int start, int end) {
        while (start < end) {
            swap(c, start++, end--);
        }
    }

    /**
     * 数据交换
     * @param c
     * @param start
     * @param end
     */
    private void swap(char[] c, int start, int end) {
        char t = c[start];
        c[start] = c[end];
        c[end] = t;
    }
}
