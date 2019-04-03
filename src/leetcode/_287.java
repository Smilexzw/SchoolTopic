package leetcode;

/**
 * @Auther: xuzhangwang
 * @Description: 287. 寻找重复数
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (79)
 * 题解
 * 提交记录
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
public class _287 {
    public static void main(String[] args) {
        // 可以使用位运算
        int[] nums = {1, 2, 3, 2, 4};
        int res = findDuplicate(nums);
        System.out.println(res);
    }

//    public static int findDuplicate(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
////        int res = 0;
////        for (int i = 0; i < nums.length; i++) {
////            res ^= nums[i];
////            if (res == 0) return nums[i];
////        }
////        return 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == nums[i]) return nums[i];
//            }
//        }
//        return 0;
//    }


    public static int findDuplicate(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2, cnt = 0;
            for (int num : nums) {
                if (num <= mid) ++cnt;
            }
            if (cnt <= mid) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}
