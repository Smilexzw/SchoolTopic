package leetcode;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class _059螺旋矩阵II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] m = generateMatrix(n);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int j = 0;
        int c = 1;
        while (c <= n * n) {
            for (int i = j; i < n - j; i++) {
                matrix[j][i] = c++;
            }
            for (int i = j + 1; i < n - j; i++) {
                matrix[i][n - j - 1] = c++;
            }
            for (int i = n - j - 2; i >= j; i--) {
                matrix[n - j - 1][i] = c++;
            }
            for (int i = n - j - 2; i > j; i--) {
                matrix[i][j] = c++;
            }
            j++;
        }
        return matrix;
    }
}
