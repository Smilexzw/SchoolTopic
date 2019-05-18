package exam;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 头条_用户喜好 {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = sc.nextInt();
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            check(arr, l, r, k);
        }
    }

    private static void check(int[] arr, int l, int r, int k) {
        int ans = 0;
        for (int i = l; i <= r; i++) {
            if (arr[i] == k) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
