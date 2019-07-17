package code;

/**
 * @author xuzhangwang
 */
public class 二分查找 {
    public static void main(String[] args) {
        int[] arr = {2,3,4,4,4,4,4,5,6,7,8};
        int res = BinarySearch(arr, 4);
        System.out.println(res);

    }

    public static int BinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (arr[start] != target) return -1;
        return start;
    }
}
