package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: xuzhangwang
 */
public class 和为S的两个数字 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5, 6, 7, 8, 9};
        int sum = 10;
        ArrayList<Integer> res = FindNumbersWithSum(arr, sum);
        System.out.println(res.toString());
    }

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length == 0) return res;

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int cur = array[left] + array[right];
            if (cur > sum) {
                right--;
            } else if (cur < sum) {
                left++;
            } else {
               return new ArrayList<>(Arrays.asList(array[left], array[right]));
            }
        }
        return res;
    }
}
