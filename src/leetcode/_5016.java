package leetcode;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:5016. 删除最外层的括号  显示英文描述
 * 用户通过次数 446
 * 用户尝试次数 469
 * 通过次数 456
 * 提交次数 577
 * 题目难度 Easy
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * <p>
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 * <p>
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 * <p>
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 * <p>
 * <p>
 * 提示：
 * <p>
 * S.length <= 10000
 * S[i] 为 "(" 或 ")"
 * S 是一个有效括号字符串
 */
public class _5016 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s = sc.nextLine();
        String res = removeOuterParentheses(s);
        System.out.println(res);
    }
    public static String removeOuterParentheses(String S) {
        if (S == null || S.length() == 0) return "";
        int n = 0;
        int l = 0;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < S.length(); i++) {
            // 删除最外面的两个括号
            if (S.charAt(i) == '(') {
                ++n;
            } else {
                --n;
            }
            if (n == 0) {
                sb.append(S.substring(l + 1, i));
                l = i + 1;
            }
        }
        return sb.toString();
    }
}
