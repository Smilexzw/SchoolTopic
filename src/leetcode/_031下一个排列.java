package leetcode;

import java.util.Arrays;

/**
 * @author: xuzhangwang
 */
public class _031下一个排列 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 如果数组的是递减，那么就没有下一个更大的排列
     * 如果没有，就冲数组中的末尾开始找到第一对，交换，
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 如果数组是递减，当前的i为-1
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 从i之后开始交换
        int start = i + 1;
        int end = nums.length - 1;
        while (start <= end) {
            int t = nums[start];
            nums[start++] = nums[end];
            nums[end--] = t;
        }
    }


    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
