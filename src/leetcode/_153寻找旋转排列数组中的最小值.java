package leetcode;

/**
 * @author xuzhangwang
 * @date 2019/7/31
 */
public class _153寻找旋转排列数组中的最小值 {

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 3, 4};
        int res = findMin(nums);
        System.out.println(res);
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 只需要二分查找出left > right 的位置
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[right]) {
                // 说明mid-right之间的都是递增
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
