package year2018;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 爱奇艺_区间表达 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int res = 0;
        for (int i = 0, j = 0; i < arr.length - 1; i = j) {

            j = i + 1;
            int pre = arr[i];
            int cur = -1;
            while (j < arr.length) {
                cur = arr[j];
                if (cur - pre != 1) {
                    res++;
                    break;
                } else {
                    pre = cur;
                    cur = arr[j++];
                }
            }
        }
        // 最后res + 1
        System.out.println(res + 1);
    }
}
