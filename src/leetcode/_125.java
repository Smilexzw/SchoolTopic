package leetcode;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 题目描述
 * 评论 (165)
 * 题解
 * 提交记录
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class _125 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean b = isPalindrome(s);
        System.out.println(b);
    }

    public static boolean isPalindrome(String s) {
        char[] cha = s.toCharArray();
        int i = 0, j = cha.length - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(cha[i]))
                i++;
            else if (!Character.isLetterOrDigit(cha[j]))
                j--;
            else if (Character.toLowerCase(cha[i]) == Character.toLowerCase(cha[j])) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
