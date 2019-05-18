package offer;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 连续子数组的最大和 {
    public static void main(String[] args) {
        int[] arr = {6, -3, -2, 7, -15, 1, 2, 2};
        int res = FindGreatestSumOfSubArray(arr);
        System.out.println(res);
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            cur += array[i];
            max = Math.max(cur, max);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
}
