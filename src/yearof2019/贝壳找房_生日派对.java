package yearof2019;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 问题 5、
 * 问题描述：
 * 在一次生日派对中，有 n 个孩子参加了派对，他们决定相互赠送礼物。他们赠送礼物的方式是：首先将每
 * 个人的名字写在一张纸条上，然后放入一个不透明的盒子内，接下来每个孩子都会从盒子中随机拿走一张
 * 纸条，这样最后每个孩子都会拿到一张纸条。然后每一个孩子会给自己拿到的纸条上对应的那个人送礼物。
 * 但是这个方式有一个问题，就是有些孩子可能会拿到写着自己名字的纸条，那么他们就会不开心。现在你
 * 需要计算一下会出现这种情况的概率是多少，即至少有一个孩子拿到写着自己名字的纸条的概率。
 * 输入描述：
 * 第一行包含一个整数𝑛，表示孩子的个数。1 ≤ 𝑛 ≤ 10 12
 * 输出描述：
 * 输出对应的答案，保留四位小数。
 * 输入样例 1
 * 2
 * 输出样例 1：
 * 0.50
 * 输入样例 2：
 * 3
 * 输出样例 2：
 * 0.66
 *
 * @author xuzhangwang
 */
public class 贝壳找房_生日派对 {
    public static void main(String[] args) {
//        /*
//         这是个组合问题,全部的组合有Ann中，全部混乱的组合有
//
//          */
//        String[] s = {"A", "B", "C", "D"};
//        List<List<String>> res = permute(s);
//        int count = 0;
//        for (List<String> list : res) {
//            if (list.get(0) == "A" || list.get(1) == "B" || list.get(2) == "C" || list.get(3) == "D") {
//                continue;
//            }
//            count++;
//            System.out.println(list.toString());
//        }
//
//        System.out.println(count);
//        System.out.println(res.size());

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        double fenzi = fun(n);
        double e = Math.E;
        double res = fenzi / e;
        int t = (int) res;
        if (res - t > 0.50) {
            t = t + 1;
        }


        System.out.println(t);
    }

    public static double fun(long number) {
        if (number <= 1)
            return 1;
        else
            return number * fun(number - 1);
    }


    public static List<List<String>> permute(String[] nums) {
        List<List<String>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<>(), nums);
        return res;
    }


    private static void helper(List<List<String>> res, List<String> list, String[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
