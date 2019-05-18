package year2018;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        helper(s1.toCharArray(), s2.toCharArray());
    }

    private static int helper(char[] c1, char[] c2) {
        int[][] dp = new int[c1.length][c2.length];

        for (int i = 0; i < c2.length; i++) {
            if (c1[0] == c2[i]) {
                dp[0][i] = 1;
            }
        }

        for (int i = 0; i < c1.length; i++) {
            if (c2[0] == c1[i]) {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < c1.length; i++) {
            for (int j = 1; j < c2.length; j++) {
                if (c1[i] == c2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
