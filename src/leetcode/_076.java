package leetcode;

/**
 * @Auther: xuzhangwang
 * @Description: 题目描述 最小覆盖字串
 * 评论 (31)
 * 题解
 * 提交记录
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 * <p>
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class _076 {
    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String res = minWindow(S, T);
        System.out.println(res);
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";
        int[] cnt = new int[128];
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        int from = 0;
        int total = t.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)]-- > 0) total--;
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++cnt[s.charAt(j++)] > 0) total++;
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }
}
