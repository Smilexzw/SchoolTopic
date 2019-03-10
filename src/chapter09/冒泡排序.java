package chapter09;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 9, 3, 4, 6, 7, 3, 2};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
