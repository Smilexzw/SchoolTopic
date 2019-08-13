package _0803;

import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/8/3
 */
public class Code1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            helper(x, arr);
        }
    }

    private static void helper(int x, int[] arr) {
        // 查询第i个用户的排名
        int t = arr[x - 1];
        double ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= t) {
                ans++;
            }
        }
        if (ans == 0) {
            System.out.println(0.000000);
            return;
        } else {
            double res = (ans - 1) / arr.length * 100;
            System.out.println(String.format("%6f", res));
        }
    }
}
