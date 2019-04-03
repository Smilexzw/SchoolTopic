package leetcode;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description: 4. 寻找两个有序数组的中位数
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (543)
 * 题解
 * 提交记录
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class _004 {
    public static void main(String[] args) {
        int[] nums1 = {3, 5, 8, 9};
        int[] nums2 = {1, 2, 7, 10, 11, 12};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            int len = nums2.length;
            if (len % 2 != 0) {
                return nums2[len / 2];
            } else {
                return (nums2[len / 2] + nums2[len / 2 - 1] / 2);
            }
        } else if (nums2 == null) {
            int len = nums1.length;
            if (len % 2 != 0) {
                return nums1[len / 2];
            } else {
                return (nums1[len / 2] + nums1[len / 2 - 1] / 2);
            }
        }
        double[] nums3 = new double[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums3[i] = nums1[i];
        }
        for (int i = nums1.length; i < nums1.length + nums2.length; i++) {
            nums3[i] = nums2[i - nums1.length];
        }


        Arrays.sort(nums3);
        int len = nums3.length;
        if (len % 2 != 0) {
            return nums3[len / 2];
        } else {
            return (nums3[len / 2] + nums3[len / 2 - 1]) / 2;
        }
    }
}
