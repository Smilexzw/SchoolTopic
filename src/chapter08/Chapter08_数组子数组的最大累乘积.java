package chapter08;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * @Auther: xuzhangwang
 * @Description: 给定一个double类型的数组arr， 其中的元素可正数，负数，0 返回子数组累乘的你最大乘积
 */
public class Chapter08_数组子数组的最大累乘积 {
    public static void main(String[] args) {

    }

    /**
     * 返回的的是数组中的最大累乘积的值
     * @param arr
     * @return
     */
    public static int maxProduct(double[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        double max = arr[0];
        double min = arr[0];
        double res = arr[0];


        // TODO
        return 0;
    }
}
