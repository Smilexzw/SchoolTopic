package leetcode;

/**
 * @author: xuzhangwang
 */
public class _033搜索旋转数组排序数组 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int res = search(arr, target);
        System.out.println(res);
    }


    /**
     * 使用二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) return mid;
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else start = mid;
            } else {
                if (nums[mid] <= nums[end]) {
                    if (nums[mid] <= target && target <= nums[end]) {
                        start = mid;
                    } else end = mid;
                }
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
}
