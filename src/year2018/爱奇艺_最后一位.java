package year2018;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 爱奇艺_最后一位 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        sc.close();

        long res = binarySearch(num, 0, num);
        System.out.println(res);

    }

    private static long getSum(long num) {
        long res = 0;
        while (num != 0) {
            res += num;
            num /= 10;
        }
        return res;
    }

    public static long binarySearch(long target, long left, long right) {
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = getSum(mid);
            if (sum == target) return mid;
            if (sum < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
