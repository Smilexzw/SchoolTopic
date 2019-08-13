package _0810;

import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/8/10
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long min = Long.MAX_VALUE;
        int start = 0;
        for (int i = 1; i < arr.length; i++) {
            long t = Math.abs(arr[i] - arr[i - 1]);
            if (min > t) {
                min = t;
                start = i;
            }
        }
        System.out.println(arr[start - 1] + " " + arr[start]);
    }
}
