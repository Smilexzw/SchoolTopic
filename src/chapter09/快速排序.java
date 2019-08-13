package chapter09;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = {9, 2, 1, 5, 7, 8, 5, 3, 2, 5};
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /*
        快速排序, 递归
     */
    private static void quicksort(int[] arr, int start, int end) {
        if (start >= end) return;

        int key = arr[end];

        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && arr[i] <= key) {
                i++;
            }
            if (i < j) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                j--;
            }
            while (i < j && arr[j] >= key) {
               j--;
            }
            if (i < j) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
            }
        }


        quicksort(arr, start, i - 1);
        quicksort(arr, i + 1, end);

    }



}
