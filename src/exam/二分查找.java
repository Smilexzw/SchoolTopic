package exam;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 二分查找 {
    public static void main(String[] args) {
        int[] data = {1, 3, 5, 6};
        int target = 5;
        int res = binarySearch(data, target);
        System.out.println(res);
    }

    /**
     * 二分搜索target插入的位置,  假设数组中无重复数据
     * @param data
     * @param target
     * @return
     */
    static int binarySearch(int[] data, int target) {
        int len = data.length;
        if (target < data[0]) {
            return 0;
        }
        if (target > data[len - 1]) {
            return len;
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (data[mid] > target) {
                right = mid - 1;
            } else if (target > data[mid]){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}
