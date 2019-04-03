package leetcode;

import java.util.HashSet;

/**
 * @Auther: xuzhangwang
 * @Description:只出现一次的数字
 */
public class _136 {
    static int[] arr = {4, 1, 2, 1, 2};

    public static void main(String[] args) {
        System.out.println(singleNumber(arr));
    }


    /**
     交换律：a ^ b ^ c <=> a ^ c ^ b
     任何数于0异或为任何数 0 ^ n => n
     相同的数异或为0: n ^ n => 0
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
