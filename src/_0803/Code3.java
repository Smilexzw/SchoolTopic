package _0803;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/8/3
 */
public class Code3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }


        boolean j = false;
        boolean o = false;
        for (int i = 0; i < n; i++) {
           if (arr[i] % 2 != 0) {
               j = true;
           }
           if (arr[i] % 2 == 0) {
               o = true;
           }
        }
        if (o && j) {
            Arrays.sort(arr);
        }
        System.out.println(Arrays.toString(arr));
    }
}

//10
//        53941 38641 31525 75864 29026 12199 83522 58200 64784 80987

// 4  7 5 3 1     7 5 3 1

