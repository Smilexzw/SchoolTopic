package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 1029. 可被 5 整除的二进制前缀  显示英文描述
 * 用户通过次数 0
 * 用户尝试次数 0
 * 通过次数 0
 * 提交次数 0
 * 题目难度 Easy
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * <p>
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * 示例 2：
 * <p>
 * 输入：[1,1,1]
 * 输出：[false,false,false]
 * 示例 3：
 * <p>
 * 输入：[0,1,1,1,1,1]
 * 输出：[true,false,false,false,true,false]
 * 示例 4：
 * <p>
 * 输入：[1,1,1,0,1]
 * 输出：[false,false,false,false,false]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 30000
 * A[i] 为 0 或 1
 */
public class _1025 {
    public static void main(String[] args) {
        int[] A = {0,1,1,1,1,1};
        prefixesDivBy5(A);
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        if (A == null || A.length == 0) return null;
        List<Boolean> list = new ArrayList<>();

        // 数组中值存放当前的数据
        int tmp = 0;
        for (int i = 0; i < A.length; i++) {
            tmp = (tmp * 2 + A[i]) % 5;
            if (tmp % 5 == 0) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
}
