package chapter04;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Auther: xuzhangwang
 * @Title: 最长公共子序列
 * @Description: 给定数组arr, 给返回arr的最长递增子序列
 */
public class Chpater04_Longest_Increasing_Subsequence {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
    }

    // 使用时间复杂度为O(N^2)的方法
    public static int[] getdp1(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + "\t");
        }
        return dp;
    }



    /*
        也可以使用最长公共子序列进行查找， 最长公子序列的方法可以参考Chapter04_Lognest_Common_Subsequence
     */
}
