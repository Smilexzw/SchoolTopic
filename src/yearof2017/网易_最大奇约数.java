package yearof2017;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 网易_最大奇约数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getSum(n));
    }

    public static long getSum(long n) {
        long sum = 0;
        while (n != 0) {
            if (n % 2 == 0) {
                sum += (n * n) >> 2;
                n = n >> 1;
            } else {
                sum += ((n + 1) * (n + 1)) >> 2;
                n = n >> 1;
            }
        }
        return sum;
    }
}
