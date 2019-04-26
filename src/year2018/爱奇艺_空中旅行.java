package year2018;

import java.util.Scanner;

/**
 * 牛牛有羊羊有了属于他们自己的飞机。于是他们进行几次连续的飞行。f[i]表示第i次飞行所需的燃油的升数。飞行只能按照f数组所描述的顺序进行。
 * 起初飞机里有s升燃油,为了正常飞行,每次飞行前飞机内燃油量应大于等于此处飞行所需要的燃油量。请帮助他们计算在不进行加油的情况下他们能进行的飞行次数。
 * 输入描述:
 * 输入包括两行,第一行包括两个整数n和s(1 ≤ n ≤ 50, 1 ≤ s ≤ 1000),分别表示计划飞行的次数和飞起初始状态下有的燃油量。
 * 第二行包括n个整数f[i], (1 ≤ f[i] ≤ 1000), 表示每次计划飞行所需要的燃油量。
 * 输出描述:
 * 输出一个整数,表示他们能进行的飞行次数。
 * 示例1
 * 输入
 * 复制
 * 7 10
 * 1 2 3 4 5 6 7
 * 输出
 * 复制
 * 4
 *
 * @author: xuzhangwang
 */
public class 爱奇艺_空中旅行 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s - arr[i] >= 0) {
                res++;
                s -= arr[i];
            } else {
                break;
            }
        }
        System.out.println(res);
    }
}
