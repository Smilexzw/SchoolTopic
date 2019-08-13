package _0803;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 4  3
 1 2 3 4
 4
 3
 1

 1
 2
 4



 3 2
 1 2 2

 1
 0





 * @author xuzhangwang
 * @date 2019/8/3
 */
public class Code4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            helper(arr, x);
        }
    }

    private static void helper(int[] arr, int x) {
        int res = 0;
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
//        System.out.println(l);
        System.out.println(Arrays.toString(arr));
        for (int i = l; i < arr.length; i++) {
            arr[i]--;
            res++;
        }
        System.out.println(res);
        System.out.println(Arrays.toString(arr));
        System.out.println("==========================");


    }
}
