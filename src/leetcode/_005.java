package leetcode;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:5. 最长回文子串
 * 题目描述
 * 评论 (493)
 * 题解
 * 提交记录
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class _005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s = longestPalindrome(str);
        System.out.println(s);
    }

    /**
     * 使用动态规划进行解决问题
     *
     * @param s
     * @return
     */
    // time O(n^2) Space(n^2) 空间用来开辟boolean[][]数组了
    private static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
            boolean[][] dp = new boolean[s.length()][s.length()];
            int max = 0;
            String res = "";
            for (int j = 0; j < s.length(); j++) {
                for (int i = 0; i <= j; i++) {   // 可以模拟处i ~ j 是否为回文
                    dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                    if (dp[i][j]) {
                        if (j - i + 1 > max) {
                            max = j - i + 1;
                            res = s.substring(i, j + 1);
                        }
                    }
                }
        }
        return res;
    }


    /**
     * 使用中心扩散方法
     *
     * @param s
     * @return
     */
     //time O(n^2) space O(1)
    static String res = "";

    public static String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }

    private static void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res = cur;
        }
    }
}
