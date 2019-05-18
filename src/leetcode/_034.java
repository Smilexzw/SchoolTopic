package leetcode;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description:34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (194)
 * 题解
 * 提交记录
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class _034 {
    public static void main(String[] args) {
        int[] nums = {1};
        int[] res = searchRange(nums, 1);
        System.out.println(Arrays.toString(res));
    }

    public static int[] searchRange(int[] nums, int target) {
        // 极端情况
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        if (target < nums[0] || target > nums[nums.length - 1]) return new int[]{-1, -1};

        int start = findFirst(nums, target);
        if (start == -1) return new int[]{-1, -1};
        int end = findLast(nums, target);
        if (end == -1) return new int[]{-1, -1};
        return new int[]{start, end};
    }

    private static int findFirst(int[] nums, int target) {
        int start = 0;
        int end =nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }

    private static int findLast(int[] nums, int target) {
        int start = 0;
        int end =nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
    }

}
