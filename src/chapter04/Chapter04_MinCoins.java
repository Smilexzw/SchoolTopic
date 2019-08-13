package chapter04;

/**
 * @Auther: xuzhangwang
 * @Description: 给定数组arr, arr中的所有的值都是正数且不重复，每个值代表一种面值的货币，每种面值的货币可以使用任意张
 * 在给定一个整数aim代表要找的钱数，求组成的aim的最少的货币数目
 */
public class Chapter04_MinCoins {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3};
        int aim = 20;
        int res = minCoins1(arr, aim);
        System.out.println(res);
    }


    public static int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0] + 1];
            }
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    left = dp[i][j - arr[i] + 1];
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }
}
