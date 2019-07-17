package leetcode;

/**
 * 思路: 使用二分查找
 * @author: xuzhangwang
 */
public class _035搜索插入位置 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int res = searchInsert(nums, 3);
        System.out.println(res);
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums[0] > target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
