package leetcode;

/**
 * @Auther: xuzhangwang
 * @Description: 题目描述
 * 评论 (22)
 * 题解
 * 提交记录
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 数学表达式如下:
 * <p>
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 */
public class _334 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        boolean b = increasingTriplet(arr);
        System.out.println(b);
    }

    public static boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) for (int k = j + 1; k < nums.length; k++) {
                    if (nums[j] < nums[k]) return true;
                }
            }
        }
        return false;
    }
}
