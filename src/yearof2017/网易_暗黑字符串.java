package yearof2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class 网易_暗黑字符串 {
    // 使用动态规划
    // 先看下动态规划的方程
    /*
         n = 1 黑暗的字符串 为3
         n = 2 暗黑的字符串 为9
         n = 3 第三个位置取决于前面的2个位置
         f(n - 1) = S(n - 1) + D(n - 1)
         有以下的决策行为
            1、 前面两个位置相同那么第三个位置无论如何都是暗黑的字符串
            2、 前面两个位置不相同，那么第三个位置只能有两种情况就是和前面两个位置相等
            所以有 f(n) = 3S(n - 1) + 2D(n - 1) = 2f(n - 1) + S(n - 1)
            所以就要分析S(n - 1)如何消去

            如果相同（假设s(n - 1)）， 那么新相加的字母ABC都可以 AAA, AAB, AAC 那么有一个相同，两个不相同
            如果不相同（假设D（n - 1））, 那么新相加的字母只能有两种， ABA, ABB, 那么就有一个相同，一个不相同
            所以s(n) = s(n - 1) + d(n - 1)
                d(n) = 2s(n - 1) + d(n - 1)
                对照第一个 算式 这有s(n) = f(n - 1)

            所以有f(n) = 2f(n - 1) + f(n - 2)
            接下来就是写代码的环节
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> list = new ArrayList<>();
        while (sc.hasNext()) {
            list.add(sc.nextLong());
        }
        sc.close();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(getSum(list.get(i)));
            } else {
                System.out.print(getSum(list.get(i)) + " ");
            }
        }
    }

    /**
     * 算出当前的结果
     * @param n
     */
    public static Long getSum(long n) {
        if (n == 1) return 3l;
        if (n == 2) return 9l;
        return 2 * getSum(n - 1) + getSum(n -2);
    }
}
