package exam;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 编程题2 {
    static int[] arr;
    static int n;
    static BigDecimal max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        max = new BigDecimal(Integer.MIN_VALUE);
        // 枚举
//        int index = 0;
//        while (index < arr.length) {
//            for (int len = 0; len < n; len++) {
//                subArr(arr, index, len);
//            }
//            index++;
//        }
//        System.out.println(max);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                subArr(arr, i, j);
            }
        }
        System.out.println(max);
    }

    /**
     * 检测当前截取的数组中的最大的值
     * @param arr
     * @param
     * @param
     */
    private static void subArr(int[] arr, int l, int r) {
        if (l > arr.length - 1 || r > arr.length - 1) return;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = l; i <= r; i++) {
           min = Math.min(min, arr[i]);
           sum += arr[i];
        }
        if (min * sum > max.intValue()) {
            max = new BigDecimal(min).multiply(new BigDecimal(sum));
        }
    }


}
