package leetcode;

import java.util.*;

/**
 * @Auther: xuzhangwang
 * @Description:239. 滑动窗口最大值
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (48)
 * 题解
 * 提交记录
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class _239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }

    /*
    使用dq进行解决问题
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length + 1 - k];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.offerLast(i);
            if ((i + 1) >= k) {
                res[i + 1 - k] = nums[dq.peek()];
            }
        }
        return res;
    }
}
