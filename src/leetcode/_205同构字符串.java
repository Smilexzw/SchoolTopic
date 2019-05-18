package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: xuzhangwang
 * @Description:205. 同构字符串
 * 题目描述
 * 评论 (91)
 * 题解
 * 提交记录
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 */
public class _205同构字符串 {
    public static void main(String[] args) {
        String s = "ab";
        String t = "aa";
        boolean res = isIsomorphic(s, t);
        System.out.println(res);
    }

    public static boolean isIsomorphic(String s, String t) {
        // 使用map进行存储，一个值对应唯一一个值
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1).equals(c2)) continue;
                else return false;
            } else {
                if (!map.containsValue(c2)) {
                    map.put(c1, c2);
                } else return false;
            }
        }
        return true;
    }

}
