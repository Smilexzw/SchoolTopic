package leetcode;

import java.util.Scanner;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

 示例 1:

 输入: 1
 输出: true
 解释: 20 = 1
 示例 2:

 输入: 16
 输出: true
 解释: 24 = 16
 示例 3:

 输入: 218
 输出: false

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/power-of-two
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _231二次幂 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean res = isPowerOfTwo(n);
        System.out.println(res);
    }

    /**
     *  通过发现可以看出
     *  2： 10
     *  4： 100
     *  8： 1000
     *  16: 10000
     *
     *  n       :      16    10000
     *  n- 1    :      15    01111
     *  (n & n - 1) == 0
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & n - 1) == 0);
    }
}
