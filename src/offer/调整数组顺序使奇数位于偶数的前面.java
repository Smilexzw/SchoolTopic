package offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，
 * 偶数和偶数之间的相对位置不变。
 *
 * @author: xuzhangwang
 */
public class 调整数组顺序使奇数位于偶数的前面 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reOrderArray(int[] array) {
      // 计算奇数的个数
        int oddCnt = 0;
        for (int val : array) {
            if (val % 2 == 1) {
                oddCnt++;
            }
        }
        int[] copy = array.clone();
        int i = 0;
        int j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1) {
                array[i++] = num;
            } else {
                array[j++] = num;
            }
        }
    }
}
