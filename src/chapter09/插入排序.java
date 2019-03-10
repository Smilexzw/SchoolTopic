package chapter09;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 插入排序 {
    public static void main(String[] args) {
        int[] arr = {9, 2, 1, 5, 7, 8, 5, 3, 2, 1, 2, 5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        // 外层控制的是趟数，n 长度的数组需要比较 n - 1次
        for (int i = 1; i < arr.length; i++) {
            int get = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > get) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = get;
            System.out.println("第" + i + "趟的排序" + Arrays.toString(arr));
        }
    }
}
