package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description: 78. 子集
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (149)
 * 题解
 * 提交记录
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class _078 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = subsets(nums);
        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i <= nums.length; i++) {
            helper(res, new ArrayList<Integer>(), nums, i, 0);
        }
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, k - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
