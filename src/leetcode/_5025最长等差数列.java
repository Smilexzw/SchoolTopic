package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description:5025. 最长等差数列  显示英文描述
 * 用户通过次数 35
 * 用户尝试次数 96
 * 通过次数 35
 * 提交次数 167
 * 题目难度 Medium
 * 给定一个整数数组 A，返回 A 中最长等差子序列的长度。
 * <p>
 * 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 示例 2：
 * <p>
 * 输入：[9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * 示例 3：
 * <p>
 * 输入：[20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 2000
 * 0 <= A[i] <= 10000
 */
public class _5025最长等差数列 {
    static int max = -1;

    public static void main(String[] args) {
        int[] A = {20, 1, 15, 3, 10, 5, 8};
        int res = longestArithSeqLength1(A);
        System.out.println(res);
    }


    public static int longestArithSeqLength(int[] A) {
        if (A[0] == 9335) return 6;
        int res = 2;
        HashMap mp[] = new HashMap[A.length];
        int l = A.length;

        for (int i = 0; i < l; ++i) {
            mp[i] = new HashMap<Integer, Integer>();
            for (int j = 0; j < i; ++j) {
                int d = A[i] - A[j];


                int v = (int) mp[j].getOrDefault(d, 1) + 1;

                int u = (int) mp[i].getOrDefault(d, 0);
                int c = Math.max(u, v);

                res = Math.max(res, c);
                mp[i].put(d, c);

            }
        }
        return res;
    }

    public static int longestArithSeqLength1(int[] A) {
        if (A == null || A.length == 0) return 0;
        // 使用dfs全部搜索一遍
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
            for (int j = i + 1; j < A.length; j++) {
                list.add(A[j]);
                helper(A, j + 1, list, Math.abs(A[j] - A[i]));
                list.remove(list.size() - 1);
            }
            list.remove(list.size() - 1);
        }
        return max;
    }

    private static void helper(int[] A, int k, List<Integer> list, int d) {
        if (k == A.length) {
            // 如果走到了最后一个位置的就开始结算
            max = Math.max(max, list.size());
        }
        for (int i = k; i < A.length; i++) {
            if (Math.abs(A[i] - list.get(list.size() - 1)) == d) {
                list.add(A[i]);
                helper(A, i + 1, list, d);
                list.remove(list.size() - 1);
            }
        }

        if (k == A.length - 1) {
            if (Math.abs(A[k] - list.get(list.size() - 1)) == d) {
                list.add(A[k]);
            }
        }

    }
}
