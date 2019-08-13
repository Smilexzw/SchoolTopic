package _0803;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/8/3
 */
public class Demo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 8};
        int x = 1;
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l <= r) {
            mid = (r - l) / 2 + l;
            if (arr[mid] == x) {
                break;
            }
            if (arr[mid] < x) {
                l = mid + 1;
            } else if (arr[mid] > x) {
                r = mid - 1;
            }
        }
        System.out.println(l);
//        System.out.println(i);
    }
}
