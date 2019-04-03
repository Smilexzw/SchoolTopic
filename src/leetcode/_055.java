package leetcode;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Title: 跳跃游戏
 * @Description:55. 跳跃游戏
 * 题目描述
 * 评论 (121)
 * 题解
 * 提交记录
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class _055 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        boolean b = canJump(nums);
        System.out.println(b);
    }

    public static boolean canJump(int[] nums) {
//        if (nums == null || nums.length == 0) return true;
//        boolean[] dp = new boolean[nums.length];
//        dp[0] = true;
//        for (int i = 0; i < nums.length; i++) {
//            // 题目的要求目前使用的是贪心算法，如果当前的位置能走到最后的位置就直接输出的
//            for (int j = 0; j <= nums[i]; j++) {
//                if (dp[i] == true) {
//                    if (i + j >= nums.length) return true;
//                    dp[i + j] = true;
//                }
//            }
//        }
//        return dp[dp.length - 1];

        // 判断当前的为位置是否大于当前的最大能跳到的位置，如果当前的位置的无法跳到直接返回fasle
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
