package leetcode;

/**
 * @author: xuzhangwang
 */
public class _029两数相除 {
    public static void main(String[] args) {
        int res = divide(29, 8);
        System.out.println(res);
    }

    public static int divide(int dividend, int divisor) {
        // 考虑特殊情况，如果符号越界就返回整形的最大值
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == - 1)) {
            return Integer.MAX_VALUE;
        }
        // 考虑正负号
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        long ms = Math.abs((long) dividend);
        long ns = Math.abs((long) divisor);
        int num = 0;
        while (ms >= ns) {
            long m = ns;
            long n = 1;
            while (ms >= (m << 1)) {
                n <<= 1;
                m <<= 1;
            }
            num += n;
            ms -= m;
        }
        return num * sign;
    }
}
