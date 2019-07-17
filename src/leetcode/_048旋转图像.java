package leetcode;

/**
 * @author: xuzhangwang
 */
public class _048旋转图像 {
    public static void main(String[] args) {
        int[][] matrix = {
                { 5, 1, 9,11},
                { 2, 4, 8,10},
                {13, 3, 6, 7},
                {15,14,12,16}
        };
        rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            // 开始旋转
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    /**
     * 旋转当前的数组
     * @param matrix
     * @param tR
     * @param tC
     * @param dR
     * @param dC
     */
    private static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dR - tR;
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = tmp;
        }
    }
}
