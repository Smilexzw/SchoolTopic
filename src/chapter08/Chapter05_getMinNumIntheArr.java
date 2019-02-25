package chapter08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 给定一个无序的数组，找出数组中最小的k个数
 */
public class Chapter05_getMinNumIntheArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 67, 3, 2, 35, 21, 31};
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int tmp = getKMinNum(arr, k);
        System.out.println("最小的k的元素:" + tmp);
    }

    // 简单的方法就是将数组进行排序，之后再去查找出第k个最小的元素
    public static int getKMinNum(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0 || k > arr.length) {
            return 0;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        int kNum = 0;
        for (int i = 1; i < arr.length; i++) {
            if (kNum == k - 1) return arr[i - 1];
            if (arr[i] != arr[i - 1]) {
                kNum++;
            }

        }
        if (k > kNum) {
            return 0;
        }
        return 0;
    }


    // 书上的方法，依靠把arr进行排序的方法太简单的，时间复杂度也不好，这里使用的是堆排序，一直维护一个有k个数的大根堆时间复杂度O(NlogK)

}
