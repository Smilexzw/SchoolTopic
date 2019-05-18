package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description:题目描述 评论 (90)
 * 题解
 * 提交记录
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class _060 {
    static int cur = 0;
    static String res = "";

    public static void main(String[] args) {
        String s = getPermutation(4, 18);
        String s1 = getPermutation1(4, 18);
        System.out.println(s);
        System.out.println(s1);
    }

    public static String getPermutation(int n, int k) {

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        helper(arr, k, new ArrayList<Integer>());
        return res;
    }

    private static void helper(int[] arr, int k, List<Integer> list) {
        if (list.size() == arr.length) {
            if (++cur == k) {
                for (int i = 0; i < list.size(); i++) {
                    res += list.get(i);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])) continue;
            list.add(arr[i]);
            helper(arr, k, list);
            list.remove(list.size() - 1);
        }

    }


    public static String getPermutation1(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }
        System.out.println(Arrays.toString(fact));
        k = k - 1;
        StringBuffer sb = new StringBuffer();
        for (int i = n; i > 0; i--) {
            int index = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(res.get(index));
            res.remove(index);
        }
        return sb.toString();
    }
}
