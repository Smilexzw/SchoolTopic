package year2018;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 搜狐_Kolakoski序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> res = solution(arr, n);
        for (Integer num : res) {
            System.out.println(num);
        }
    }


    public static ArrayList<Integer> solution(int[] array, int n) {
        int m = array.length;
        ArrayList<Integer> res = new ArrayList<>();
        int k = 0; // 用于标志 array 数组索引
        int count = 0; // 用于计数，控制循环次数
        while (res.size() < n) {
            if (k == m) // 当数组里的数字都已经出现过一遍时，需要从头再开始
                k = 0;
            res.add(array[k]); // 每次先将第一个不同的数添加
            // System.out.println("" + res.get(count));
            // 关键就是控制下面循环添加的次数，因为该序列的数字，本身就是相邻相同数字的个数
            for (int i = 0; i < res.get(count) - 1; i++) {
                res.add(array[k]);
            }
            k++;
            count++;
        }
        // for (k = 0; k < n; k++)
        // System.out.println("" + res.get(k));
        // 如果要求 Kolakoski 序列的第 x 项，构造完后 res.get(x); 即可
        return res;
    }

}
