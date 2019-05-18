package offer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] m = {{1},{2},{3},{4},{5}};
        ArrayList<Integer> res = printMatrix(m);
        System.out.println(res.toString());

    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        ArrayList<Integer> res = new ArrayList<>();
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, res, tR++, tC++, dR--, dC--);
        }
        return res;
    }

    private static void printEdge(int[][] m, ArrayList<Integer> res, int tR, int tC, int dR, int dC) {
        // 如果只有一行
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                res.add(m[tR][i]);
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                res.add(m[i][tC]);
            }
        } else {
            int curR = tR;
            int curC = tC;
            while (curC != dC) {
                res.add(m[tR][curC]);
                curC++;
            }

            while (curR != dR) {
                res.add(m[curR][dC]);
                curR++;
            }

            while (curC != tC) {
                res.add(m[dR][curC]);
                curC--;
            }

            while (curR != tR) {
                res.add(m[curR][tC]);
                curR--;
            }
        }
    }
}
