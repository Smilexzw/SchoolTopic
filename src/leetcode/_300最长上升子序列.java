package leetcode;

import java.util.Arrays;

/**
 * @author xuzhangwang
 * @date 2019/8/12
 */
public class _300最长上升子序列 {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(arr);
        System.out.println(res);
    }


    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int j = Arrays.binarySearch(dp, 0, len, num);
            if (j < 0) {
                j = -(j + 1);
            }
            dp[j] = num;
            if (j == len) {
                len++;
            }
        }
//        System.out.println(Arrays.toString(dp));
        return len;
    }
}
