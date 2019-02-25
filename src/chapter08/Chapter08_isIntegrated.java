package chapter08;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Auther: xuzhangwang
 * @Description: 最长的可整合子数组长度
 * 先给出可整合数组定义，如果一个数组在排序之后， 你每个相邻的数差的绝对值都为1，则该数组为可整合数组
 */
public class Chapter08_isIntegrated {

    public static void main(String[] args) {
        int[] arr = {5, 5 ,3, 2, 6, 4, 3};
        int tmp = getLIL2(arr);
        System.out.println(tmp);
    }

    public static int getLIL1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                // 只需要判断数组arr[i ... j]位置是否连续递增的，递增的长度为1
                if (isIntergrated(arr, i, j)) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }


    public static boolean isIntergrated(int[] arr, int left, int right) {
        // 将数组的位置进行copy
        int[] newArr = Arrays.copyOfRange(arr, left, right + 1);
        Arrays.sort(newArr);
        for (int i = 1; i < newArr.length; i++) {
            if (newArr[i - 1] + 1 != newArr[i]) {
                return false;
            }
        }
        return true;
    }

    public static int getLIL2(int[] arr) {
        if (arr ==null || arr.length == 0) {
            return 0;
        }
        int len = 0;
        int max = 0;
        int min = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                // 判断重复-如果重复就不符合规则
                if (set.contains(arr[j])) {
                    break;
                }
                set.add(arr[j]);
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                if (max - min == j - i) {
                    len = Math.max(len, j - i + 1);
                }
            }
            // 每一次都要得清楚set中的值
            set.clear();
        }
        return len;
    }

}
