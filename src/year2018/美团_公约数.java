package year2018;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 美团_公约数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int X = arr[i] + arr[j];
                System.out.println(X);
                int gcd = gcd(X, A);
                if (gcd >= B) {
                    System.out.println(gcd);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
