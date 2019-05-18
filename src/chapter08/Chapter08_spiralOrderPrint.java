package chapter08;

/**
 * @Auther: xuzhangwang
 * @Description: 给定一个整型数组matrix，清按照转圈的方式打印它
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * 13 14 15 16
 * 打印的结果为:1,2,3,4,8,12,16,15,14,13, 9, 5, 6, 7, 11, 10
 *
 */
public class Chapter08_spiralOrderPrint {
    public static void main(String[] args) {
        int[][] martix = { {1, 2, 3, 4},
                           {5, 6, 7, 8},
                           {9, 10, 11, 12},
                           {13,14,15,16}
                         };
        spiralOrderPrint(martix);
    }

    // 设置左上角的坐标(tR, tC) 右下角坐标(dR, dC),只需要知道这两个坐标就可以打印出来旋转数组
    public static void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {
            // 子矩阵只有一行的时候
            for (int i = tC; i <= dC; i++) {
                System.out.print(m[tR][i] + " ");
            }
        } else if (tC == dC) {
            // 子矩阵只有一列的时候
            for (int i = tR; i <= dR ; i++) {
                System.out.print(m[i][tC] + " ");
            }
        } else {
            // 一般的情况就转圈打印
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.print(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.print(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.print(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.print(m[curR][tC] + " ");
                curR--;
            }
        }
    }
}
