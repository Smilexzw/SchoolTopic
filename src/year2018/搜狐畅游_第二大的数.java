package year2018;

import java.util.Scanner;

/**
 * 题目描述
 * 输入n个整数，查找数组中第二大的数
 * 输入描述:
 * 第一行n表示n个数，第二行n个空格隔开的数
 * 输出描述:
 * 输出第二大的数
 * 示例1
 * 输入
 * 复制
 * 5
 * 1 2 3 4 5
 *
 * @author: xuzhangwang
 */
public class 搜狐畅游_第二大的数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        sc.close();
//        int max = Integer.MIN_VALUE;
//        int second = Integer.MIN_VALUE;
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] > max) {
//                second = max;
//                max = arr[i];
//            } else if (arr[i] > second) {
//                second = arr[i];
//            }
//        }
//        if (second == Integer.MIN_VALUE) {
//            System.out.println(max);
//        } else {
//            System.out.println(second);
//        }

        int max = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;
        while (sc.hasNextInt()) {
            int t = sc.nextInt();
            if (t > max) {
                sec = max;
                max = t;
            } else if (t > sec) {
                sec = t;
            }
        }

        if (sec == Integer.MIN_VALUE) {
            System.out.println(max);
        } else {
            System.out.println(sec);
        }
    }
}
