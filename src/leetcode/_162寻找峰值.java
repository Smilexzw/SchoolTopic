package leetcode;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * <p>
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 *      或者返回索引 5， 其峰值元素为 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-peak-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xuzhangwang
 * @date 2019/7/31
 */
public class _162寻找峰值 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        int res = findPeakElement(arr);
        System.out.println(res);
    }

    /**
     * 使用二分查找进行
     * 简单的来说上坡就有坡顶
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[mid + 1]) {
                // 说明在mid之前存在峰值
                right = mid;
            } else {
                // 说明在mid之后存在峰值
                left = mid + 1;
            }
        }
        return left;
    }

}
