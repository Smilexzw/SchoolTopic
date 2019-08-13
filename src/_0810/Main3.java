package _0810;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/8/10
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // 排序，从小开始
        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i] * 10 / 9;
            int temp = 0;
            for ( ; i + temp < arr.length ; temp++) {
                if (max < arr[i + temp]) {
                    break;
                }
            }
            temp = temp - 1;
            result += temp;
        }

        System.out.println(result);
    }
}
