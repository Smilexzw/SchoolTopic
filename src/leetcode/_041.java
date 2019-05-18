package leetcode;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description:41. 缺失的第一个正数
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (198)
 * 题解
 * 提交记录
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: [7,8,9,11,12]
 * 输出: 1
 */
public class _041 {
    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        int res = firstMissingPositive(nums);
        System.out.println(res);
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        // 对应的位置要存放对应的数字
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}
