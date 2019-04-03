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
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> list : permute) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        dfs(nums, 0, res);
        return res;
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
