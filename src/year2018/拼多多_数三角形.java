package year2018;

import java.util.Scanner;

/**
 * 题目描述
 * 给出平面上的n个点，现在需要你求出，在这n个点里选3个点能构成一个三角形的方案有几种。
 * <p>
 * <p>
 * 输入描述:
 * 第一行包含一个正整数n，表示平面上有n个点（n <= 100)
 * 第2行到第n + 1行，每行有两个整数，表示这个点的x坐标和y坐标。(所有坐标的绝对值小于等于100，且保证所有坐标不同）
 * 输出描述:
 * 输出一个数，表示能构成三角形的方案数。
 * 示例1
 * 输入
 * 复制
 * 4
 * 0 0
 * 0 1
 * 1 0
 * 1 1
 * 输出
 * 复制
 * 4
 * 说明
 * 4个点中任意选择3个都能构成三角形
 *
 * @author: xuzhangwang
 */
public class 拼多多_数三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        sc.close();

        int count = 0;
        // 只要三点不共线就可以组成三角形
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // 算出斜率  (x1 - x2) * (y1 - y3) == (x1 - x3) * (y1 - y2) 三点共线
                    int a = ((arr[i][0] - arr[j][0]) * (arr[i][1] - arr[k][1]));
                    int b = ((arr[i][0] - arr[k][0]) * (arr[i][1] - arr[j][1]));
                    if (a != b) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
