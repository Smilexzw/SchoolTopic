package _0810;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 小希偶然得到了传说中的月光宝盒,然而打开月光宝盒需要一串密码。虽然小希并不知道密码具体是什么，但是月光宝盒的说明书上有着一个长度为 n (2 <= N <= 50000)的序列 a (-10^9 <= a[i] <= 10^9)的范围内。下面写着一段话：密码是这个序列的最长的严格上升子序列的长度(严格上升子序列是指，子序列的元素是严格递增的，例如: [5,1,6,2,4]的最长严格上升子序列为[1,2,4])，请你帮小希找到这个密码。
 * <p>
 * <p>
 * 输入
 * 第1行：1个数N，N为序列的长度(2<=N<=50000)
 * <p>
 * 第2到 N+1行：每行1个数，对应序列的元素(-10^9 <= a[i] <= 10^9)
 * <p>
 * 输出
 * 一个正整数表示严格最长上升子序列的长度
 * <p>
 * <p>
 * 样例输入
 * 8
 * 5
 * 1
 * 6
 * 8
 * 2
 * 4
 * 5
 * 10
 *
 * @author xuzhangwang
 * @date 2019/8/10
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long res = helper(arr);
        System.out.println(res);


    }

    private static long helper(long[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        long[] dp = new long[arr.length];
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            // 在dp中搜索，判断改数据已应该出现的地方
           int j = Arrays.binarySearch(dp, 0 , len, arr[i]);
           if (j < 0) {
               // 使用系统的二分搜索会出现负数，所以需要转换为正数
               j = -(j + 1);
           }
           dp[j] = arr[i];
           if (j == len) {
               len++;
           }
        }
        return len;
    }


}
