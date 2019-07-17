package offer;

/**
 * 使用二分查找
 * @author xuzhangwang
 */
public class 数字在排序数组中出现次数 {

    public static void main(String[] args) {
        int[] array  = {1, 2, 3, 3, 3, 3, 4, 6};
        int k = 3;
        int res = GetNumberOfK(array, k);
        System.out.println(res);
    }

    public static int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0 ) return -1;
        return binarySearch(array, k + 0.5) - binarySearch(array, k - 0.5);
    }

    public static int binarySearch(int[] array, double k) {

        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;

            if(array[mid] < k)
                l = mid + 1;
            else if(array[mid] > k)
                r = mid - 1;
        }
        return l;
    }


}
