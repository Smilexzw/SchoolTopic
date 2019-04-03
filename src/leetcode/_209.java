package leetcode;

/**
 * 知识点 : 滑动窗口
 * @Auther: xuzhangwang
 * @Description: 209. 长度最小的子数组
 * 题目描述
 * 评论 (61)
 * 题解
 * 提交记录
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class _209 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int res = minSubArrayLen(7, nums);
        System.out.println(res);
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (left <= i && sum >= s) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
