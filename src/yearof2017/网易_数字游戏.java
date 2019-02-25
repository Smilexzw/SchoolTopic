package yearof2017;

import java.util.Arrays;
import java.util.Scanner;

public class 网易_数字游戏 {
    // 给定一串数据, 数据是无法充成小易给定的数字 , 输出最小不能由n个数选取求和组成的数
    // 你找出无法从n个数中选取部分求和的数字中的最小数（从1开始）
    // 例如: 5 1 2   能输出的有 1  2  3  5  6  7  8 所以输出最小的数据为4
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(arr);
        int miss = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > miss + 1) break;
            miss += arr[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(miss + 1);
    }
}

