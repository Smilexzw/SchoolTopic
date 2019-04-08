package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class _090 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        Arrays.sort(nums);
        List<List<Integer>> res = subsetsWithDup(nums);
        for (List<Integer> list : res) {
            System.out.println(list.toString());
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i <= nums.length; i++) {
            helper(res, new ArrayList<>(), nums, i, 0);
        }
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            helper(res, list, nums, k - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
