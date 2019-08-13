package leetcode;

/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。

  

 示例 1：

 输入：00000000000000000000000000001011
 输出：3
 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 示例 2：

 输入：00000000000000000000000010000000
 输出：1
 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 示例 3：

 输入：11111111111111111111111111111101
 输出：31
 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/number-of-1-bits
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xuzhangwang
 * @date 2019/7/31
 */
public class _191位1的个数 {
    public static void main(String[] args) {
        hammingWeight(7);
    }

    public static int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int res = 0;
        while (n != 0) {
            int mod = n % 2;
            if (mod == 1) {
                res++;
            }
            n /= 2;
        }
        System.out.println(res);
        System.out.println(s);
        return 0;
    }
}
