package exam;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 二分查找 {
    public static void main(String[] args) {
        int[] data = {1, 2, 2, 4, 5, 6, 6, 7, 8, 9, 9 ,10};
        int tmp = BinarySearchMax(data, 2);
        System.out.println(tmp);
    }

    static int BinarySearchMax(int[] data, int target) {
        int left = 0;
        int right = data.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            int tmp = data[mid];
            if (tmp <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (data[right] == target)
            return right;
        return -1;
    }


}
