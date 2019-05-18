package year2018;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 爱奇艺_幸运子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int first = Integer.MIN_VALUE;
            int second = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (arr[j] > first) {
                    second = first;
                    first = arr[j];
                } else if (arr[j] > second) {
                    second = arr[j];
                }
            }
            max = Math.max(max, first ^ second);
        }
        System.out.println(max);
    }
}
