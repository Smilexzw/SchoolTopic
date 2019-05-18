package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description:66. 加一
 * <p>
 * <p>
 * <p>
 * <p>
 * 题目描述
 * 评论 (507)
 * 题解
 * 提交记录
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class _066加一 {
    public static void main(String[] args) {

        int[] dig = {9, 9, 9, 9};
        int[] ints = plusOne(dig);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
