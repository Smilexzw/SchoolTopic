package leetcode;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description: 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class _152 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int unZeroCount = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 将数组中非0的数据移动
            if (nums[i] != 0) {
                nums[unZeroCount] = nums[i];
                unZeroCount++;
            }
        }

        // 数据中为0 的数据 = 数组的长度 - 数组中为0 的个数
        int zeroCount = len - unZeroCount;
        for (int i = len - 1; i > 0; i--) {
            if (zeroCount == 0) return;
            nums[i] = 0;
            zeroCount--;
        }
    }
}
