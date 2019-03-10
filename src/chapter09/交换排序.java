package chapter09;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description: 交换排序的思路是每一次把最小放到当前的第一个位置
 */
public class 交换排序 {
    public static void main(String[] args) {
        int[] arr = {9, 2, 1, 5, 7, 8, 5, 3, 2, 1, 2, 5};
        changeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void changeSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }

            if (index != i) {
                int tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }

            System.out.println("第" + (i + 1) + "次排序结果" + Arrays.toString(arr));
        }
    }
}
