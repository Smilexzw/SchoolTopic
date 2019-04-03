package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:_03最长无重复的字串的长度
 */
public class _003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = lengthOfLongestSubstring(s);
        System.out.println("hashTable的方法:" + res);
    }

    /**
     * 返回最长的无重复的字串的长度
     *
     * @param s
     * @return 使用的是HashMap的方法
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
