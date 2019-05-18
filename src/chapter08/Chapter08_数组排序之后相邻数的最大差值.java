package chapter08;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description: 给定一个整型数组arr，返回排序后的相邻两数的最大差值
 */
public class Chapter08_数组排序之后相邻数的最大差值 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 22, 110, 99, 77, 70, 66, 100, 101 };
        int res = maxGap(arr);
        System.out.println(res);
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    /**
     * 如果使用排序的思想的话时间的复杂度会是NLogN, 为了实现更低的时间复杂度， 这个用下面的方法进行计算
     * 利用桶排序的思想（不是直接进行的桶排序 ） 可以做到时间复杂为O（N） 额外的时间的复杂度为O(N)
     * 实现的方法具体如下
     * 1、先算出maxs和mins数组
     * 2、只要算出最大和最小数组就可以知道每一个的区间的最大和最小的值
     * 3、最大差值只可能来自某个的非空桶的最小值减去前一个非空桶的最大值。
     * @param arr
     * @return
     */
    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        if (max == min) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i], len, min, max); // 算出桶号
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(mins[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = 0;
        int i = 0;
        while (i <= len) {
            if (hasNum[i++]) {      // 找出第一个的不为空桶
                lastMax = maxs[i - 1];
                break;
            }
        }
        for ( ; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }

        return res;
    }


    /**
     * 计算出数组中的每一个位置的桶号
     * @param num
     * @param len
     * @param min
     * @param max
     * @return
     */
    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }



}
