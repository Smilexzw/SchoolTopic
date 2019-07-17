package _702;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuzhangwang
 */
public class 万万没想到之抓捕孔连顺 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        long count = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            while (i >= 2 && arr[i] - arr[j] > D) {
                j++;
            }
            count += fun(i - j);
        }
        System.out.println(count % 99997876);

    }

    
    public static long fun(long n) {
        return (n - 1) * n / 2;
    }
    
}
