package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 题目描述 跳跃游戏
 * 评论 (82)
 * 题解
 * 提交记录
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class _045 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        int jump = jump2(arr);
        System.out.println(jump);
    }


    /**
     * 目前这个方法只通过了91/92的测试用例
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 使用dp求出每一个位置的最小步数, 第一个位置使用的是0个步数
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) for (int j = 0; j <= nums[i]; j++) {
                if (i + j < nums.length) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }
        return dp[dp.length - 1];
    }

    /**
     * 使用贪心
     * @param nums
     * @return
     */
    // time O(n) space O(1)
    public static int jump2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int res = 0;
        int curMaxArea = 0;
        int maxNext = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxNext = Math.max(maxNext, i + nums[i]);
            if (i == curMaxArea) {
                res++;
                curMaxArea = maxNext;
            }
        }
        return res;
    }
}
