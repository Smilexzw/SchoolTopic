package yearof2017;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 搜狐_袋鼠过河 {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        // 使用动态的规划进行查看
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(dp(arr));
    }

    private static int dp(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        int n = arr.length;
        // 设计每每一个位置跳到的最小步数
        for (int i = 0; i < arr.length; i++) {
            if(dp[i] != Integer.MAX_VALUE)for (int j = 0; j <= arr[i]; j++) {
                if (i + j <= arr.length - 1) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                } if (i + j > arr.length - 1) {
                    return dp[i] + 1;
                }
            }
        }
        if (dp[n - 1] > 0 && arr[n - 1] != 0) {
            return dp[n - 1] + 1;
        } else {
            return -1;
        }
    }


}
