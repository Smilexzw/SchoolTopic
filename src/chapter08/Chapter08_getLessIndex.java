package chapter08;

/**
 * @Auther: xuzhangwang
 * @Description: 在数组中找到一个局部最小的位置
 * 定义局部最小的概念。arr长度为1时， arr[0]是局部最小。arr的长度为N（N > 1）时候，如果
 */
public class Chapter08_getLessIndex {
    public static void main(String[] args) {
        int[] arr = {3, 3, 4, 2, 5, 2, 1, 5, 6};
        int index = getLessIndex(arr);
        System.out.println(index);
    }

    /**
     * 返回-1表示不存在
     * @param arr
     * @return
     */
    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        // 以上已经做出了头部和尾部的判断， 接下来就要判断其他的情况， 使用的是二分查找的方法
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

}
