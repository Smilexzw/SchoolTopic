package chapter05;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class Chapter05_getPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String tmp = getPalindrome1(str);
        System.out.println(tmp);
    }

    /*
     这个问题使用动态规划进行解决dp[i][j] 代表是的最少添加几个字符使得的str[i...j]整体都是回文字符串
     1、如果str只有一个字符，那么dp[i][j] = 0
     2、如哦str只有两个字符，那么dp[i][j] = 1, 最少添加的一个字符就可以使得整体字符串变成回文字符串
     3、如果str字符超过两个字符，那么如果str[i] == str[j], 那么dp[i][j] = dp[i+1][j-1],
           如果str[i] != str[j]， 那么就有让str[i.. j-1]先变成字符串，要么就是让str[i+1...j]变成回文字符串
    */
    public static int[][] getDp(char[] str) {
        int[][] dp = new int[str.length][str.length];
        for (int j = 1; j < str.length; j++) {
            dp[j - 1][j] = str[j - 1] == str[j] ? 0 : 1;
            for (int i = j - 2; i > -1 ; i--) {
                if (str[i] == str[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp;
    }


    public static String getPalindrome1(String str){
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] chas = str.toCharArray();
        int[][] dp = getDp(chas);
        // 最后形成回文字符串的长度str.length + dp[0][N-1]
        char[] res = new char[chas.length + dp[0][chas.length - 1]];
        System.out.println(res.length);
        /*
            如果字符串str[i....j] 中str[i] == str[j] 那么res = str[i] + str[i+1...j-1] + str[j]
            如果字符串str[i....j] 中str[j] != str[j] 那么看dp[i][j-1]和dp[i+1..j]那个更小
            最终得到的结果的是str[j] + str[i...j-1]变成回文字符串的结果 + str[i]
            同理如果是dp[i-1][j]更小的就有结果的有str[i...j] 变成的回文字符串的最终结果的str[i] + str[i+1..j] + str[i]
         */
        int i = 0;
        int j = chas.length - 1;
        int resl = 0;
        int resr = res.length - 1;
        while (i <= j) {
            if (chas[i] == chas[j]) {
                res[resl++] = chas[i++];
                res[resr--] = chas[j--];
            } else if (dp[i][j - 1] < dp[i + 1][j]) {
                res[resl++] = chas[j];
                res[resr--] = chas[j--];
            } else {
                res[resl++] = chas[i];
                res[resr--] = chas[i++];
            }
        }
        return String.valueOf(res);
    }
}