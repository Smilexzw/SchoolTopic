package chapter03;

/**
 * @author: xuzhangwang
 */
public class 根据后序数组判断是否为二叉搜索树 {
    public static void main(String[] args) {
//        int[] arr = {1,3, 2, 5, 7, 6, 4};
        int[] arr = {2, 1, 3, 6, 5, 7, 4};
        boolean res = isPostArray(arr);
        System.out.println(res);
    }

    /**
     * 做出判断
     *
     * @param arr
     * @return
     */
    private static boolean isPostArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        return isPost(arr, 0, arr.length - 1);
    }

    private static boolean isPost(int[] arr, int start, int end) {
        if (start == end) {
            return true;
        }

        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (arr[end] > arr[i]) {
                less = i;
            } else {
                more = more == end ? i : more;
            }
        }

        if (less == -1 || more == end) {
            return isPost(arr, start, end - 1);
        }

        if (less != more - 1) {
            return false;
        }

        return isPost(arr, start, less) && isPost(arr, more, end - 1);
    }
}
