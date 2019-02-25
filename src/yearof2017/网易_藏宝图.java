package yearof2017;
import java.util.Scanner;

public class 网易_藏宝图 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str_1 = sc.nextLine();
        String str_2 = sc.nextLine();
        int m = str_1.length();
        int n = str_2.length();
        // 创建一个二位数组用来存放数据, 这道题目只要判断两个字符串的公共子序列是否等于字符串二
        int[][] dp = new int[m + 1][n + 1];
        // 空串的时候为0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str_1.charAt(i - 1) == str_2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        if (dp[m][n] == n) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
