package offer;



/**
 * @author xuzhangwang
 */
public class 数组中的逆序对 {

    private static int count = 0;
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,0};
        int res = InversePairs1(arr);
        System.out.println(res);
    }


    /* 要求对于50%的数据中的size <= 10 ^ 4
       要求对于50%的数据中的size <= 10 ^ 5
       要求对于50%的数据中的size <= 2 * 10 ^ 5

       暴力输出可以获得50%的成绩
       尝试使用map进行降低时间复杂度
     */
    public static int InversePairs(int [] array) {
        if (array == null || array.length == 0) return 0;
        int mod = 1000000007;
        int P = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    P = (++P) % mod;
                }
            }
        }
        return P;
    }


    public static int InversePairs1(int [] array) {
        if (array == null || array.length == 0) return -1;
        megerSort(array, 0, array.length - 1);
        return count;
    }

    private static void megerSort(int[] array, int left, int right) {
        if (left < right) {
            int mi = (left + right) / 2;
            megerSort(array, left, mi );
            megerSort(array, mi + 1,right);
            meger(array, left, mi, right);
        }
    }

    public static void meger(int[] a, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int t = right - left;//临时数组下标
        int l = mid;
        int r = right;
        while (l >= left && r >= mid + 1) {
            if (a[l] > a[r]) {
                count += (r - mid);
                tmp[t--] = a[l--];
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                tmp[t--] = a[r--];
            }
        }
        while (l >= left) {
            tmp[t--] = a[l--];
        }
        while (r >= mid + 1) {
            tmp[t--] = a[r--];
        }
        for (int i = 0; i <= right - left; i++) {
            a[left + i] = tmp[i];
        }
    }
}
