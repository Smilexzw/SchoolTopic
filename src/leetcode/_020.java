package leetcode;

import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @Auther: xuzhangwang
 * @Description: 20. 有效的括号
 * 题目描述
 * 评论 (540)
 * 题解
 * 提交记录
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class _020 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean valid = isValid(s);
        System.out.println(valid);
    }

    // 这是一类型题目，使用Stack处理
    public static boolean isValid(String s) {
        if (s ==null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != ch) return false;
            }
        }
        return stack.isEmpty();
    }
}
