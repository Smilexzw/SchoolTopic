package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

 示例 1:

 输入: nums: [1, 1, 1, 1, 1], S: 3
 输出: 5
 解释:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 一共有5种方法让最终目标和为3。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/target-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xuzhangwang
 * @date 2019/7/31
 */
public class _494目标和 {

    static int res = 0;
    public static int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        dfs(nums, S, 0, 0);
        return res;
    }

    private static void dfs(int[] nums,int S, int k, int cur) {
        if (k == nums.length) {
            if (cur == S) {
                res++;
                return;
            }
            return;
        }
        dfs(nums, S, k + 1, cur + nums[k]);
        dfs(nums, S, k + 1, cur - nums[k]);
    }

    public static void main(String[] args) {
        int[] nums = {1000};
        int S = -1000;
        int result = findTargetSumWays(nums, S);
        System.out.println(result);
    }
}
