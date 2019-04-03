package leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Auther: xuzhangwang
 * @Description: 1028. 负二进制转换  显示英文描述
 * 用户通过次数 147
 * 用户尝试次数 213
 * 通过次数 148
 * 提交次数 405
 * 题目难度 Medium
 * 给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。
 * <p>
 * 除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出："110"
 * 解释：(-2) ^ 2 + (-2) ^ 1 = 2
 * 示例 2：
 * <p>
 * 输入：3
 * 输出："111"
 * 解释：(-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 * 示例 3：
 * <p>
 * 输入：4
 * 输出："100"
 * 解释：(-2) ^ 2 = 4
 */
public class _1028 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(baseNeg2(sc.nextInt()));
    }

    public static String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        int a = 0;
        Stack<Integer> stack = new Stack<>();
        while (N != 0) {
            a = Math.abs(N % -2);
            stack.push(a);
            N = (N - a) / -2;
        }
        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
