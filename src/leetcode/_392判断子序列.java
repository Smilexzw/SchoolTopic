package leetcode;

import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/8/10
 */
public class _392判断子序列 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        boolean res = isSubsequence(a, b);
        System.out.println(res);
    }

    /**
     * 贪心, 维持两个指针开始遍历，找到匹配就移动两个指针向后
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
//        int count = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
//                count++;
            }
            j++;
//            count++;
        }
//        System.out.println("操作次数" + count);
        if (i == s.length()) {
            return true;
        } else {
            return false;
        }
    }
}
