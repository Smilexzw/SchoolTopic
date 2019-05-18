


















































































                                package leetcode;

import java.util.*;

/**
 * @Auther: xuzhangwang
 * @Description:451. 根据字符出现频率排序
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (47)
 * 题解
 * 提交记录
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 * <p>
 * 输入:
 * "cccaaa"
 */
public class _451根据字符出现频率排序 {
    public static void main(String[] args) {
        String s = "bbAa";
        String res = frequencySort(s);
        System.out.println(res);
    }
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, ((o1, o2) -> (o2.getValue() - o1.getValue())));
        String res = "";
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                res += entry.getKey();
            }
        }
        return res;
    }
}
