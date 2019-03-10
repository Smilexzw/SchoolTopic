package chapter09;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 希尔排序 {
    public static void main(String[] args) {
        int arr[] = {32, 24, 95, 45, 75, 22, 95, 49, 3, 76};
        shellSort(arr);
    }

    private static void shellSort(int[] arr) {
        int d = arr.length / 2;  // d代表的是当前的分割数组的距离
        int x, j, k = 1;
        while (d >= 1) {
            for (int i = d; i < arr.length; i++) {
                x = arr[i];
                j = i - d;
                while (j >= 0 && arr[j] > x) {
                    // 换
                    arr[j + d] = arr[j];
                    j = j - d;
                }
                arr[j+d] = x;
            }
            d /= 2;

            System.out.println("第" + k++ + "次排序" + Arrays.toString(arr));
        }
    }
}
