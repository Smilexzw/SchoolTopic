package chapter04;

/**
 * @Auther: xuzhangwang
 * @Title: 最长公共子序列
 * @Description: 给定两个字符串str1和str2，返回两个字符串的最长公共子序列
 */
public class Chapter04_Longest_Common_Subsequence {
    public static void main(String[] args) {
        String str1 = "215364897";
        String str2 = "123456789";
        String common = lcse(str1, str2);
        System.out.println(common);
    }

    // 使用动态规划求出dp, 算出第一行与第一列中相等
    public static int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], str1[i] == str2[0] ? 1 : 0);
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
//        for (int i = 1; i < str1.length; i++) {
//            for (int j = 1; j < str2.length; j++) {
//                if (str1[i] == str2[j]) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp;
    }

    public static String lcse(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "";
        }
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp =  getdp(chs1, chs2);
        int m = chs1.length - 1;
        int n = chs2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = chs1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }

}
