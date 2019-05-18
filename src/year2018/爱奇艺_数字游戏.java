package year2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 爱奇艺_数字游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < n; i++) {
            helper(arr, i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
    }

    private static void helper(int[] arr, int k) {
        int n = arr[k];
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }
        Collections.sort(list);
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res = res * 10 + list.get(i);
        }
        arr[k] = res;
    }

}
