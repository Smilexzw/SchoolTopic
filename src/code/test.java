package code;

import java.util.Arrays;

/**
 * @Auther: xuzhangwang
 * @Description: 测试数组的切分的方法
 */
public class test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, 1)));

        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, 2)));
    }
}
