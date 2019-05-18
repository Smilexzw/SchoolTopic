package year2018;

import java.util.Scanner;

/**
 * 题目描述
 * 牛牛有4根木棍,长度分别为a,b,c,d。羊羊家提供改变木棍长度的服务,
 * 如果牛牛支付一个硬币就可以让一根木棍的长度加一或者减一。
 * 牛牛需要用这四根木棍拼凑一个正方形出来,
 * 牛牛最少需要支付多少硬币才能让这四根木棍拼凑出正方形。
 * 输入描述:
 * 输入包括一行,四个整数a,b,c,d(1 ≤ a,b,c,d ≤ 10^6), 以空格分割
 * 输出描述:
 * 输出一个整数,表示牛牛最少需要支付的硬币
 * 示例1
 * 输入
 * 复制
 * 4 1 5 4
 * 输出
 * 复制
 * 4
 * <p>
 * 思路: 找出最大和最小,分别取中间的位置计算
 *
 * @author: xuzhangwang
 */
public class 爱奇艺_拼凑正方形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int[] arr = {a, b, c, d};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        int res = Integer.MAX_VALUE;
        for (int i = min; i <= max; i++) {
            int t = Math.abs(a -i) + Math.abs(b - i) + Math.abs(c - i) + Math.abs(d - i);
            res = Math.min(res, t);
        }
        System.out.println(res);
    }
}
