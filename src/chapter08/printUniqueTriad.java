package chapter08;

/**
 * @Auther: xuzhangwang
 * @Description: 不重复打印排序数组中相加和为给定值的所有的二元组和三元组
 */
public class printUniqueTriad {

    public static void main(String[] args) {
//        int[] arr = {1, 1, 1, 9};
        int[] arr = {-8, -4, -3, 0, 1, 2, 4, 5, 8, 9};
        printUniqueTraid2(arr, 10);
    }

    /**
     * 因为给定的数组是已经排序之后
     * 所以自需要判断arr[left] + arr[right] ?== k
     * @param arr
     */
    public static void printUniqueTraid(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < k) {
                left++;
            } else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                // 判断是否是重复
//                if (left == 0 || arr[left - 1] !=arr[left]) {
                    System.out.println(arr[left] + "," + arr[right]);
//                }
                right--;
                left++;
            }
        }
    }


    public static void printUniqueTraid2(int[] arr, int k) {
        if (arr == null || arr.length < 3) {
            return;
        }
        // 只需要判断第一个之后的数组中是否存在二元数组等于的之前的数
        for (int i = 0; i < arr.length; i++) {
            printRest(arr, i, i + 1, arr.length - 1, k - arr[i]);
        }
    }

    public static void printRest(int[] arr, int f, int l, int r, int k) {
        while(l < r) {
            if (arr[l] + arr[r] < k) {
                l++;
            } else if (arr[l] +arr[r] > k) {
                r--;
            } else {
                // 判断
                if (l == f + 1 || arr[l - 1] != arr[l]){
                    System.out.println(arr[f] + "," + arr[l] + "," + arr[r]);
                }
                r--;
                l++;
            }
        }
    }
}
