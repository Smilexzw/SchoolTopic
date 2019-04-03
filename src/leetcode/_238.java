package leetcode;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description: 238. 除自身以外数组的乘积
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (52)
 * 题解
 * 提交记录
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class _238 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 4};
        int[] res = productExceptSelf(nums);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 这种做法时间复杂度O(n2)，因为要套两层loop。其实有很多的重复求乘积的步骤，在此优化
     *              [1, 2, 3, 4]
     * 左边的乘积    [1, 1, 2, 6]
     * 右边的乘积    [24,12,4, 1]
     * 结果 = 左*右  [24,12,8, 6]
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        int[] arr = new int[nums.length];

        int left = 1;
        int right = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[i] = left;
            left *= nums[i];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] *= right;
            right *= nums[i];
        }
        return arr;
    }
}
