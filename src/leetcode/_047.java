package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description: 47. 全排列 II
 * 题目描述
 * 评论 (77)
 * 题解
 * 提交记录
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class _047 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        List<List<Integer>> res = permuteUnique(nums);
        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    /*
        进行没有重复元素的全排列
     */
    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            helper(res, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
