package chapter08;

/**
 * @Auther: xuzhangwang
 * @Description: 计算数组中的小和
 * 数组小和的定义如下
 *      例如，数组s=【1，3， 4， 2， 4， 6】在s【0】的坐标小于或等于s[0]的数和为0，在s【1】的左边的小于或等于s【1】的数的和为1
 *      在s【2】的左边小于或等于s【2】的数的和为1+3=4，。。。。。
 *
 *     给定一个数组s，实现函数返回s的小和
 */
public class Chapter08_getSmallSum {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 4, 6};
        int tmp = getSmallSum(arr);
        System.out.println(tmp);
    }


    /**
     * 时间复杂度为n^2实现的方法如下
     * @param arr
     * @return
     */
    public static int getSmallSum2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = 0;
            for (int j = i; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    tmp += arr[j];
                }
            }
            sum += tmp;
        }
        return sum;
    }

    /**
     * 用时间复杂度为O(NLogN)额外空间复杂度为O（N）的方法
     * @param arr
     * @return
     */
    public static int getSmallSum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return func(arr, 0 ,arr.length - 1);
    }

    /**
     * 利用归并排序进行计算的每一个阶段的最小和的结果
     * @param s
     * @param l
     * @param r
     * @return
     */
    public static int func(int[] s, int l, int r) {
        if (l == r) {
            return 0;
        }

        int mid = (l + r) / 2;
        return func(s, l, mid) + func(s, mid + 1, r) + meger(s, l ,mid, r);
    }

    /**
     * 具体计算如下
     * [1, 3, 5] 和 [2, 4, 6]
     * 1<2 2算自己之后有三个所以  1x3
     * 3>2 3<4 所以有 3x2=6
     * 5<6 所以有 5x1
     *
     * @param s
     * @param left
     * @param mid
     * @param right
     * @return
     */
    public static int meger(int[] s, int left, int mid, int right) {
        // 创建一个新的数组用来计算的每一个阶段产生的最小的结果
        int[] h = new int[right - left  + 1];
        int h1 = 0;
        int i = left;
        int j = mid + 1;
        int smallSum = 0;
        while (i <= mid && j <=right) {
            if (s[i] <= s[j]) {
                smallSum += s[i] * (right - j + 1);
                // 进行数组的整合
                h[h1++] = s[i++];
            } else {
                h[h1++] = s[j++];
            }
        }
        for (; (j < right + 1) || (i < mid + 1); j++ , i++) {
            h[h1++] = i > mid ? s[j] : s[i];
        }
        for (int k = 0; k != h.length ; k++) {
            s[left++] = h[k];
        }
        return smallSum;
    }


}
