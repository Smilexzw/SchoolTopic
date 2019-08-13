package yearof2019;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuzhangwang
 */
public class 贝壳找房_填方格 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            fun(n);
        }
    }

    private static void fun(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] left = new int[n];
        int[] right = new int[n];
        int len = arr.length;
        left[0] = arr[0];
        right[len - 1] = arr[len - 1];
        for (int i = 1; i < arr.length - 1; i++) {
            int t = arr[i] + left[i - 1];
            left[i] = t;
        }

        for (int i = len - 2; i > 0; i--) {
            right[i] = arr[i] + right[i + 1];
        }
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (left[i] == right[i + 1]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
