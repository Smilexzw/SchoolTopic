package chapter08;

/**
 * @Auther: xuzhangwang
 * @Description: 自然数数组的排序
 * 给定一个长度的为N的整形数组arr，其中有N个互不相等的的自然数1~n,请事先arr的Paiute，但是不要把下标0~N-1的位置上的数通过直接
 * 赋值的方法替换成为1~N
 *
 */
public class Chapter08_sort {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1, 4};
        sort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }

    /**
     * 方法1
     * 1、从左到右遍历arr，假设当前遍历到i位置上
     * 2、如果arr[i] == i + 1， 则代表当前元素是在这个位置的
     * 3、如果arr[i] != i + 1, 则代表当前元素不再这个位置上面，进行数据的替换
     */
    public static void sort1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int tmp = 0;
        int next = 0;
        for (int i = 0; i != arr.length ; i++) {
            tmp = arr[i];
            while (arr[i] != i + 1) {
                next = arr[tmp - 1];
                arr[tmp - 1] = tmp;
                tmp = next;
             }
        }
    }

    /**
     * 1、从左到右遍历
     * 2、如果arr[i] == i+1, 说明当前的位置是不需要的调整的，继续遍历下一个位置
     * 3、如果arr[i] != i+1, 说明当前的位置是需要进行调整的。
     * @param arr
     */
    public static void sort2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int tmp = 0;
        for (int i = 0; i != arr.length ; i++) {
            while(arr[i] != i + 1) {
                tmp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = tmp;
            }
        }
    }


}
