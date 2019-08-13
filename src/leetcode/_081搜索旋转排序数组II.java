package leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

 示例 1:

 输入: nums = [2,5,6,0,0,1,2], target = 0
 输出: true
 示例 2:

 输入: nums = [2,5,6,0,0,1,2], target = 3
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xuzhangwang
 * @date 2019/7/31
 */
public class _081搜索旋转排序数组II {

    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        int target = 3;
        boolean res = search(arr, target);
        System.out.println(res);
    }


    public static boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) return true;
            if (nums[l] == nums[r] && nums[r] == nums[mid]) {
                l++;
                r--;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            // 如果出现nums[mid] >= nums[r]
        }
        return false;
    }
}
