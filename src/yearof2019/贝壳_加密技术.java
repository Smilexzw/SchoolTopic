package yearof2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 问题1、 问题描述： 小A设计了一种新的加密技术，可以采用一种聪明的办法在一个字符串中的字符之间插入随机字符串，从 而对信息进行编码。出于保密考虑，关于如何在原有信息中产生和插入字符串的方式不会详细阐述。但为 了验证方法的有效性，需要编写一个程序来验证原来的信息是否全在编码后的字符串中。给定两个字符串 s和t，需要判断s是否是t的“子序列”。即如果去掉 t 中的某些字符，剩下字符可以连接构成字符串s。

 输入描述： 输入中包括多组测试样例（不超过1000组）。每组测试样例是由空格分隔的两个字符串构成，每个字符串 由ASCII码字母或数字组成，长度不超过100000。
 输出描述： 对每个测试样例单独输出一行，若s为t的“子序列”，则输出"Yes"，否则输出"No"。
 输入样例： sequence subsequence person compression VERDI vivaVittorioEmanueleReDiItalia
 caseDoesMatter CaseDoesMatter 输出样例： Yes No Yes No


 * @author xuzhangwang
 * @date 2019/8/10
 */
public class 贝壳_加密技术 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }


    public static int[][] helper(String a, String b) {
        char[] str1 = a.toCharArray();
        char[] str2 = b.toCharArray();
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        for (int j = 1; j < str2.length; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
        }

        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }


    public static boolean longStr(String s1, String s2) {
        if (s1 == null || s1.equals("") || s2 == null || s2.equals("")) {
            return false;
        }
        int[][] dp = helper(s1, s2);
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        int m = chs1.length - 1;
        int n = chs2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else  if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = chs1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res).equals(s1);
    }
}
