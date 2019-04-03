package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description:179. 最大数
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (58)
 * 题解
 * 提交记录
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class _179 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        String s = largestNumber(nums);
        System.out.println(s);
    }

    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i);
        }
        int index = 0;
        boolean isZero = false;
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) - '0' == 0) {
                index++;
                isZero = true;
            } else break;
        }

        if (isZero) {
            return "0";
        } else {
            return res;
        }

    }
}
