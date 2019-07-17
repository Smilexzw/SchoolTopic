package _0702;

import java.util.Map;
import java.util.Scanner;

/**
 * @author xuzhangwang
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                res++;
            } else {
                res += (arr[i] / min);
            }
        }
        System.out.println(res);
    }
}
