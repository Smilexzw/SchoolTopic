package leetcode;

/**
 * @Auther: xuzhangwang
 * @Description: 242. 有效的字母异位词
 * 题目描述
 * 评论 (129)
 * 题解
 * 提交记录
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class _242有效的字母异位词 {
    public static void main(String[] args) {
        String s = "";
        String t = "";
        boolean res = isAnagram(s, t);
        System.out.println(res);
    }

    /*
        使用字典进行查询的
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] dict = new int[128];
        for (int i = 0; i < s.length(); i++) {
            dict[s.charAt(i)]++;
        }

        for (int j = 0; j < t.length(); j++) {
            if (dict[t.charAt(j)] == 0) return false;
            else {
                dict[t.charAt(j)]--;
            }
        }
        return true;
    }
}
