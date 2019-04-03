package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 17. 电话号码的字母组合
 * 题目描述
 * 评论 (218)
 * 题解
 * 提交记录
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class _017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        List<String> list = letterCombinations(digits);
        for (String s : list) {
            System.out.print(s + "\t");
        }

    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0 || digits == "") return new ArrayList<String>();
        List<String> res = new ArrayList<>();
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//        for (int i = 0; i < digits.length(); i++) {
            helper(digits, dict, 0, "", res);
//        }
        return res;
    }

    private static void helper(String digits, String[] dict, int level, String out, List<String> res) {
        if (level == digits.length()) {
            res.add(out);
            return;
        }

        String str = dict[digits.charAt(level) - '0'];
        for (int i = 0; i < str.length(); i++) {
            helper(digits, dict, level + 1, out + str.substring(i, i + 1), res);
        }
    }
}
