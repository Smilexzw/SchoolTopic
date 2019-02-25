package chapter08;

/**
 * @Auther: xuzhangwang
 * @Title: 需要排序的最短子数组长度
 * @Description: 给定一个无序的数组arr，求出需要排序的最短子数组的长度
 */
public class Chapter08_getMinArrLength {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 4, 1, 6, 7};
        int tmp = getMinArrlength(arr);
        System.out.println(tmp);
    }


    public static int getMinArrlength(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int min = arr[arr.length - 1];
        int noMinIndex = -1;
        for (int i = arr.length - 2; i != -1 ; i--) {
            if (arr[i] > min) {
                noMinIndex = i;
            } else {
                min = Math.min(min, arr[i]);
            }
        }
        if (noMinIndex == -1) return 0;
        int max = arr[0];
        int noMaxIndex = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < max) {
                noMaxIndex = i;
            } else  {
                max = Math.max(max, arr[i]);
            }
        }
        return noMaxIndex - noMinIndex + 1;
    }
}
