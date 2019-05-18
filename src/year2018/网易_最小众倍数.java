package year2018;
import java.util.Scanner;

/**
 * 题目描述
 * 给定5个正整数, 它们的最小的众倍数是指的能够被其中至少三个数整除的最小正整数。 给定5个不同的正整数, 请计算输出它们的最小众倍数。
 * 输入描述:
 * 输入包括一行,一行中有五个各不相同的正整数a, b, c, d, e(1 ≤ a, b, c, d, e ≤ 100), 以空格分割
 * 输出描述:
 * 输出一个整数,表示它们的最小众倍数
 * 示例1
 * 输入
 * 复制
 * 1 2 3 4 5
 * 输出
 * 复制
 * 4
 *
 * @author: xuzhangwang
 */
public class 网易_最小众倍数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        int res = 0, count = 0;
        while (count < 3) {
            ++res;
            count = 0;
            for (int e : arr) {
                if (res % e == 0) {
                    count++;
                }
            }
        }

        System.out.println(res);
    }
}
