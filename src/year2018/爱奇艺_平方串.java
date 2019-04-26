package year2018;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 爱奇艺_平方串 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String s = in.next();
        if (s.length() == 1) System.out.println(0);
        else {
            int res = 0, i, n = s.length();
            for (i = 0; i + 1 < n; i++)
                res = Math.max(res, maxLen(s.substring(0, i + 1), s.substring(i + 1)));
            System.out.println(res);
        }
    }

    public static int maxLen(String a, String b) {
        int len1 = a.length(), len2 = b.length(), i, j;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (i = 1; i <= len1; i++)
            for (j = 1; j <= len2; j++)
                dp[i][j] = (a.charAt(i - 1) == b.charAt(j - 1)
                        ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]));
        return dp[len1][len2] * 2;
    }
}


