package _316;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class Code4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < M; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int ans = 0;
        int index = 1;
        while(true) {
            int sum = 0;
            int res = arr[N - 1] / index;
            for (int i = N - 1; i >= 0 ; i--) {
                sum += (arr[i] % res);
            }
            if (sum == M) {
                System.out.println(res);
                break;
            } else {
                index++;
            }
        }
    }
}
