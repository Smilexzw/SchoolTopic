package yearof2017;

import java.util.Scanner;

/**
 *
 * @ClassName: 美团点评_拼凑面额
 * @Description: 给你六种面值的1，5，10，20， 50，100的纸币，假设每种纸币的数量足够多，编写要求组成的N元的不同组合的个数
 * @author xuzhangwang
 * @date 2019年1月13日
 *
 */
public class 美团点评_拼凑面额 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = {1, 5, 10, 20, 50, 100};
        long tmp = coins(arr, N);
        System.out.println(tmp);
    }

    // 使用动态规划的方法
    public static long coins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        long[][] dp = new long[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] =  1;
        }
        long num = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }
}
