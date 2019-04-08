package leetcode;

import java.util.Arrays;
import java.util.Map;

/**
 * @Auther: xuzhangwang
 * @Description: 322. 零钱兑换
 * <p>
 * <p>
 * <p>
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 */
public class _322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int res = coinChange(coins, 11);
        System.out.println(res);
    }

    /**
     * 使用动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < coins[0] || amount < 0) return -1;
        Arrays.sort(coins);
        int n = coins.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][amount + 1];
        for (int j = 1; j <= amount; j++) {
            dp[0][j] = max;
            if (j - coins[0] >= 0 && dp[0][j - coins[0]] != max) {
                dp[0][j] = dp[0][j - coins[0]] + 1;
            }
        }

        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                left = max;
                if (j - coins[i] >= 0 && dp[i][j - coins[i]] != max) {
                    left = dp[i][j - coins[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[n - 1][amount] != max ? dp[n - 1][amount] : -1;
    }
}
