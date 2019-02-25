package chapter04;

/**
 * @Auther: xuzhangwang
 * @Description: 给定数组arr, arr中的所有的值都是正数且不重复，每个值代表一种面值的货币，每种面值的货币可以使用任意张
 * 在给定一个整数aim代表要找的钱数，求组成的aim的最少的货币数目
 */
public class Chapter04_MinCoins {
    public static void main(String[] args) {

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
        }
        return 0;
    }
}
