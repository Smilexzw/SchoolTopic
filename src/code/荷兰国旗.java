package code;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description: 问题描述：给定一个k，把比k小的放数组的左边，=k的放中间，>k的放右边。
 * <p>
 * 题解：
 * <p>
 *         就是快排中的partition步骤。
 * <p>
 *         用less指针表示比k小的最后一个元素的位置，more表示比k大的第一个元素的位置。
 * <p>
 *         用cur指针指向当前位置，如果当前元素小于k，直接把它和less+1位置交换，并且less++。由于less以及less以前的必然小于k，所以less+1必然大于等于k（如果<k,只能是cur就在less+1的位置），所以直接交换，cur也右移。
 * <p>
 *         如果>k，那么就和more-1位置元素交换，并且more--。由于more-1位置不知道数是多大，所以cur不能动，需要再次比较。
 */
public class 荷兰国旗 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 9, 7, 6, 1, 4, 5};
        int[] partition = partition(arr, 0, arr.length - 1, 4);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(partition));
    }

    public static int[] partition(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] < num) {
                swap(arr, ++less, L++);
            } else if (arr[L] > num) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        return new int[] {less + 1, more - 1};
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
