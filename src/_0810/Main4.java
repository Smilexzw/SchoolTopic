package _0810;

import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/8/10
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr =new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int start = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                start = i;
                break;
            }
        }

        int end = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i + 1] >= arr[i]) {
                end  = i;
                break;
            }
        }

        // 说明是递增或则是递减的, 不需要操作为 0
        if (start == -1 || end == -1) {
            System.out.println(0);
            return;
        }

        System.out.println(start + " " + end);
        // 其他的都是不符合
        if (start > end) {

        }


    }
}



//import java.util.Scanner;
//
///**
// * @author xuzhangwang
// * @date 2019/8/10
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr =new int[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextInt();
//        }
//
//        int start = -1;
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] < arr[i - 1]) {
//                start = i;
//                break;
//            }
//        }
//
//        int end = -1;
//        for (int i = arr.length - 2; i >= 0; i--) {
//            if (arr[i + 1] > arr[i]) {
//                end  = i;
//                break;
//            }
//        }
//        int len = end - start + 1;
//        int left = arr[start - 1];
//        int right = arr[end + 1];
//        if (end < start) {
//            return;
//        }
////        System.out.println(start);
////        System.out.println(end);
//
//        int max = -1;
//        for (int i = start; i <= end ; i++) {
//            max = Math.max(max, arr[i]);
//        }
//
//        int min = -1;
//        min = left > right ? right : left;
//        if (min + len > max) {
//            System.out.println(min + len);
//        } else {
//            System.out.println(max);
//        }
//    }
//}
