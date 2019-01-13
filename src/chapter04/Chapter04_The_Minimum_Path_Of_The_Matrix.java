package chapter04;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 矩阵的最小路劲和
 * @Title: 给定一个矩阵m， 从左上角开始每次只能向右或则向下走，最后到达右下角的位置，
 *        路径上的所有的数字累加起来就是路径和，返回所有的路径中最小的路径和
 */
public class Chapter04_The_Minimum_Path_Of_The_Matrix {
    public static void main(String[] args) {
//        int[][] m = {
//                        {1, 3, 5, 9},
//                        {8, 1, 3, 4},
//                        {5, 0, 6, 1},
//                         {8, 8, 4, 0}
//                    };
        int[][] m = {{ 3, 1, 0 }, { 4, 3, 2 }, { 5, 2, 1 }, {4, 2, 1}};
        int min1 = minPathSum1(m);
        System.out.println(min1);
        System.out.println("=============");
        int min2 = minPathSum2(m);
        System.out.println(min2);
    }

    // 使用经典的动态规划的方法
    public static int minPathSum1(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        // 第一列数字相加到dp矩阵的第一列中
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        // 第一行数字相加到dp矩阵的第一行中
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }

        // 将剩下的数字相加到dp矩阵中
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i][j - 1] + m[i][j], dp[i - 1][j] + m[i][j]);
            }
        }

        // 测试打印出来dp矩阵
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[row - 1][col - 1];
    }

    // 使用动态规划的空间压缩的方法
    public static int minPathSum2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int more = Math.max(m.length, m[0].length);   // 行数与列数较大的那个为more
        int less = Math.min(m.length, m[0].length);   // 行数与列数较小的那个为less
        boolean rowmore = more == m.length;
        int[] arr = new int[less];
        arr[0] = m[0][0];
        for (int i = 1; i < less; i++) {
            arr[i] = arr[i - 1] + (rowmore ? m[0][i] : m[i][0]);
        }
        for (int i = 1; i < more; i++) {
            arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
            for (int j = 1; j < less; j++) {
                arr[j] = Math.min(arr[j - 1], arr[j]) + (rowmore ? m[i][j] : m[j][i]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        return arr[less - 1];
    }

}
