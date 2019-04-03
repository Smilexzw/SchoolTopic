package leetcode;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description: 题目描述
 * 评论 (316)
 * 题解
 * 提交记录
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 */
public class _088 {
    static int[] num1 = {1, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] num2 = {2, 5, 6};

    public static void main(String[] args) {
        merge(num1, 3, num2, 3);
    }

    /**
     * 合并两个数组，num1的数据可以看成无限的
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 1 && n == 0) return;
        int len = m + n - 1;
        for (int i = len; i >= m; i--) {
            nums1[i] = nums2[--n];
        }

        // 做算法题目最好不要使用JAVA的API
//        Arrays.sort(nums1);
        // 使用快速排序
        quickSort(nums1, 0, len);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int key = arr[end];

        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && arr[i] <= key) {
                i++;
            }
            if (i < j) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                j--;
            }
            while (i < j && arr[j] >= key) {
                j--;
            }
            if (i < j) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
            }
        }


        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }
}
