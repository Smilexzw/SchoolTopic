package leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Auther: xuzhangwang
 * @Description:202. 快乐数
 * 题目描述
 * 评论 (131)
 * 题解
 * 提交记录
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class _202快乐数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean res = isHappy(n);
        System.out.println(res);
    }

    /*
    快乐的数是快乐数字，不快乐的数字就是不快乐，必定出现相同的一次
     */
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int k = n;
        while (true) {
            int sum = 0;
            while (k != 0) {
                sum += Math.pow(k % 10, 2);
                k /= 10;
            }

            // 如果结果为1就是快乐
            if (sum == 1) return true;
            else if (set.contains(sum)) return false;
            else {
                set.add(sum);
                k = sum;
            }
        }
    }
}
