package chapter08;

/**
 * @Auther: xuzhangwang
 * @Description: 子数组中最大累加和问题
 * 给定一个数组arr， 返回子数组的最大累加和
 * 例如， arr={1, -2, 3, 5, -2, 6, -1}, 所有的子数组中，【3， 5， -2， 6】可以累加出最大的和为12，所以返回12
 */
public class Chapter08_maxSum {
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, -2, 6, -1};
        int tmp = maxSum(arr);
        System.out.println(tmp);
    }

    /**
     * 如果arr中没有正数，产生的最大累加和一定是数组中最大的值
     * 如果arr中有正数，从左到右遍历arr，用变量cur记录每一步的累加和，遍历到正数crr增加，遍历到负数cur减少
     * 当cur<0说明累加到当前出现小于0的结果，那么累加的这一部分就不能当作产生最大累加和子数组左部分
     * @param arr
     * @return
     */
    public static int maxSum(int[] arr) {
        if (arr == null ||arr.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i != arr.length; i++) {
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
}
