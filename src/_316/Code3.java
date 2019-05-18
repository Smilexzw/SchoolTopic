package _316;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class Code3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = sc.nextInt();
            }
            arr(arr);
        }

    }

    public static void arr(int[] arr) {
        int[] dp = new int[arr.length];
        if (arr[0] >= arr[1] && arr[0] >= arr[arr.length - 1]) {
            dp[0] = arr[0];
        } else {
            dp[0] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1] && arr[i] >= arr[(i + 1) % arr.length]) {
                dp[i] = arr[i];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            ans += dp[i];
        }
        System.out.println(ans);
    }
}
