package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description: 46. 全排列
 * 题目描述
 * 评论 (176)
 * 题解
 * 提交记录
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 */
public class _046 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        long s1 = System.currentTimeMillis();
        List<List<Integer>> permute = permute(nums);
        long e1 = System.currentTimeMillis();
        System.out.println(e1 - s1);

        long s2 = System.currentTimeMillis();
        List<List<Integer>> permute1 = permute1(nums);
        long e2 = System.currentTimeMillis();
        System.out.println(e2 - s2);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<>(), nums);
        return res;
    }

    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        dfs(nums, 0, res);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }

    /**
     * 使用dfs进行去全排列
     *
     * @param nums
     * @param res
     */
    private static void dfs(int[] nums, int k, List<List<Integer>> res) {
        if (k == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            res.add(list);
        }

        for (int i = k; i < nums.length; i++) {
            int t = nums[i];
            nums[i] = nums[k];
            nums[k] = t;

            dfs(nums, k + 1, res);
            t = nums[i];
            nums[i] = nums[k];
            nums[k] = t;
        }
    }
}
