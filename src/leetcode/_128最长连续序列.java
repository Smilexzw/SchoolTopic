package leetcode;

import java.util.HashMap;

/**
 * @author: xuzhangwang
 */
public class _128最长连续序列 {


    public static void main(String[] args) {
        int[] nums = {100 , 4, 200, 1, 2, 3};
        int res = longestConsecutive(nums);
        System.out.println(res);
    }

    /**
     * 使用hashmap<Integer, Integer> key存放的是当前的arr[i], value为arr[i]所在的最大的连续序列长度。
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 最少的时候只用一个
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                if (map.containsKey(nums[i] - 1)) {
                    max = Math.max(max, merge(map, nums[i] - 1, nums[i]));
                }
                if(map.containsKey(nums[i] + 1)) {
                    max = Math.max(max, merge(map, nums[i], nums[i] + 1));
                }
            }
        }
        return max;
    }

    /**
     * 合并
     * @param map
     * @param less
     * @param more
     * @return
     */
    private static int merge(HashMap<Integer, Integer> map, int less, int more) {
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }
}
