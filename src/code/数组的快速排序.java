package code;

import java.util.Arrays;

/**
 * @author xuzhangwang
 */
public class 数组的快速排序 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 1, 5, 6, 7, 811, 23, 4, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 数组的快速排序
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void quickSort(int[] arr, int start, int end) {
        // 1、递归的出口，如果当前start==end证明了当前的已经将数组分为两个部分
        if (start > end) {
            return;
        }

        // 2、取key，每次使用最右边
        int key = arr[end];

        // 3、使用变量
        int i = start;
        int j = end;

        // 一旦start == end 的时候代表两个指针已经汇合到一起
        while (i < j) {
            while (i < j && arr[i] <= key) {
                i++;
            }
            if (i < j) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
                j--;
            }

            // 从右边开始遍历如果比基准大，就继续后退
            while (i < j && arr[j] >= key) {
                j--;
            }
            if (i < j) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
                i++;
            }
        }

        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }
}
