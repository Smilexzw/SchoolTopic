package chapter08;

/**
 * @Auther: xuzhangwang
 * @Description: 未排序正数数组中累加和为给定值的最长子数组的长度
 */
public class Chapter08_getMaxLength {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1 ,1};
        int tmp = getMaxLength(arr, 3);
        System.out.println(tmp);
    }

    /*
        给定未排序的数组，给定值，求最长的子数组长度
        开始给定left = right = 0;
        如果arr[left] + arr[right] > sum 就令left++
        if sum < k , 并且right不能越界 right++;
        sum == k 就判断len, 如果更大就进行更新
     */
    public static int getMaxLength(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int len = 0;
        int sum = arr[0];
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else if (sum < k) {
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left--];
            }
        }
        return len;
    }
}
