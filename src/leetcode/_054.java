package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description: 54. 螺旋矩阵
 * 题目描述
 * 评论 (126)
 * 题解
 * 提交记录
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class _054 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list.toString());
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(res, matrix, tR++, tC++, dR--, dC--);
        }
        return res;
    }

    private static void printEdge(List<Integer> list, int[][] m, int tR, int tC, int dR, int dC) {
        // 如果只有当一行的时候
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                list.add(m[tR][i]);
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                list.add(m[i][tC]);
            }
        } else { // 一般的情况
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                list.add(m[tR][curC]);
                curC++;
            }
            while (curR != dR) {
                list.add(m[curR][dC]);
                curR++;
            }
            while (curC != tC) {
                list.add(m[dR][curC]);
                curC--;
            }
            while (curR != tR) {
                list.add(m[curR][tC]);
                curR--;
            }
        }
    }


}
