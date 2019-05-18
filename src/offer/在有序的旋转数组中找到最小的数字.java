package offer;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 在有序的旋转数组中找到最小的数字 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 1};
        int res = minNumberInRotateArray(arr);
        System.out.println(res);
    }

    /**
     * 只要找出的arr[low] > arr[high] 的位置就可以
     *
     * @param arr
     * @return
     */
    public static int minNumberInRotateArray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low < high) {
            if (low == high - 1) {
                break;
            }
            if (arr[low] < arr[high]) {
                return arr[low];
            }
            mid = (low + high) / 2;
            if (arr[low] > arr[mid]) {
                high = mid;
                continue;
            }
            if (arr[mid] > arr[high]) {
                low = mid;
                continue;
            }
            while (low < high) {
                if (arr[low] == arr[mid]) {
                    low++;
                } else if (arr[low] < arr[mid]) {
                    return arr[low];
                } else {
                    high = mid;
                    break;
                }
            }
        }
        return Math.min(arr[low], arr[high]);
    }
}
