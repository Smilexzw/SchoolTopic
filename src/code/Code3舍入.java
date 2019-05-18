package code;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class Code3舍入 {
    static List<Double> list = new ArrayList<>();
    static String s = "";
    static double min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        String[] prices = {"0.700","2.800","4.900"};
        String res = minimizeError(prices, 9);
        System.out.println(res);
    }

    public static String minimizeError(String[] prices, int target) {
        double[] p = new double[prices.length];
        // 向上舍入
        double[] c = new double[prices.length];
        // 向下舍入
        double[] f = new double[prices.length];
        for (int i = 0; i < prices.length; i++) {
            p[i] = Double.valueOf(prices[i]);
            c[i] = Math.ceil(Double.valueOf(prices[i]));
            f[i] = Math.floor(Double.valueOf(prices[i]));
            if (c[i] % 2 != 0 || f[i] % 2 != 0) {

            }
        }
        double max = 0;
        for (int i = 0; i < c.length; i++) {
            max += c[i];
        }
        if (max < target) return "-1";

        helper(c, f, p, target, 0, 0);
        if (min == Integer.MAX_VALUE) return "-1";
        BigDecimal b = new BigDecimal(min);
        min = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        String result = String.format("%.3f", min);
        return result;
    }

    private static void helper(double[] c, double[] f, double[] p, int target, int k, double ans) {
        if (target < 0) return;
        if (k == p.length && target == 0) {

            // 开始结算
            if (ans < min) {
                min = ans;
            }
        }
        for (int i = k; i < p.length; i++) {
//            list.add(c[i]);
            ans += Math.abs(p[i] - c[i]);
            helper(c, f, p, (int) (target - c[i]), k + 1, ans);
//            list.remove(list.size() - 1);
            ans -= Math.abs(p[i] - c[i]);
//            list.add(f[i]);
            ans += Math.abs(p[i] - f[i]);
            helper(c,f,p, (int) (target- f[i]), k+ 1, ans);
//            list.remove(list.size() - 1);
            ans -= Math.abs(p[i] - f[i]);
        }
    }
}
