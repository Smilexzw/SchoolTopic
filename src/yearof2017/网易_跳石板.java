package yearof2017;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @ClassName: WangYi_Jumpingslab
 * @Description: 网易笔试题目, 跳石板
 * @author xuzhangwang
 * @date 2018年9月26日
 *
 */
public class 网易_跳石板 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int min = getMinTemp(m, n);
            System.out.println(min);
        }
        sc.close();
    }

    /**
     *
     * @Title: getMinTemp
     * @Description:
     * @param @param n
     * @param @param m
     * @param @return    参数
     * @return int    返回类型
     * @throws
     */
    public static int getMinTemp(int m, int n) {
        // 从石板m, 跳到石板n, 但是有个规则就是, m往下跳只能使用m的约数
        // 创建一个数组, 用来存放m~n中能跳到的位置, 初始数组为整形的最大值, 如果能到达dp[i] 则置换这个数值
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[m] = 0;
        for (int i = m; i < dp.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            // 如果当前的数组的位置数值不是整形的最大值说明当前的是可以继续跳下去的
            // 即获取当前的数值约数(除了1和本身)继续向下跳, 记录当前走的步数, 所以创建一个方法获取当前数的约束
            // 后一个位置取决于当前位置的
            ArrayList<Integer> list = getList(i);
            for (int j = 0; j < list.size(); j++) {
                int x = list.get(j);
                if (i + list.get(j) <= n) {
                    dp[i + x] = Math.min(dp[i + x], dp[i] + 1);
                }
            }
        }
        return (dp[dp.length - 1] == Integer.MAX_VALUE) ? -1 :dp[dp.length - 1];
    }

    public static ArrayList<Integer> getList(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                // 还有一个数字 , 例如12 2是12的约数, 则6也是12的约数 , 但是36的时候 ,只能添加一次6
                if (n / i != i) {
                    list.add(n / i);
                }
            }
        }
        return list;
    }

}

