package yearof2017;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 使用动态规划来解决问题
 * @author CodeXU
 *
 */
public class 滴滴_数字和为sum的方法数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        // dp[i][j] 表示的为前i个数字能达到和为j的方法数
        long[][] dp = new long[n + 1][sum + 1];
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        // 0个物品凑成j的方法为0
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        // i个物品凑成0的方法为1
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        // dp[i][j] = dp[i-1][j]只用了前i-1个物品就凑成了j
        // dp[i][j] = dp[i-1][j] + dp[i][j-a[i]]前i-1个物品凑成了j + (前i-1个物品+当前的物品凑成了j)的方法数
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // 如果当前的j大于a[i] 就有
                if (j >= arr[i]) {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][sum]);
    }
}
