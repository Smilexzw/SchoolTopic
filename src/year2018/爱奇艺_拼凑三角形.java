package year2018;

import java.util.Scanner;

/**
 * 题目描述
 * 牛牛手中有三根木棍,长度分别是a,b,c。牛牛可以把任一一根木棍长度削短,牛牛的目标是让这三根木棍构成一个三角形,并且牛牛还希望这个三角形的周长越大越好。
 * 输入描述:
 * 输入包括一行,一行中有正整数a, b, c(1 ≤ a, b, c ≤ 100), 以空格分割
 * 输出描述:
 * 输出一个整数,表示能拼凑出的周长最大的三角形。
 * 示例1
 * 输入
 * 复制
 * 1 2 3
 * 输出
 * 复制
 * 5
 *
 * @author: xuzhangwang
 */
public class 爱奇艺_拼凑三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // 对于三角形有两边之和要大于第三边
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                for (int k = 1; k <= c; k++) {
                    if (i + j > k && i + k > j && j + k > i) {
                        max = Math.max(max, i +j + k);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
