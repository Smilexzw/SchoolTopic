package chapter08;

/**
 * @Auther: xuzhangwang
 * @Description: 将正方形矩阵顺时针转动90度
 * 给定一个N * N 的矩阵matrix, 把这个矩阵调整为顺时针转动的90度后的形式
 */
public class Chapter08_rotateEdge {
    public static void main(String[] args) {
        int[][] martix = { {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13,14,15,16}
        };
        rotate(martix);
        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < martix[0].length; j++) {
                System.out.print(martix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
        这里仍然使用的是转圈来出现代码
     */
    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            printEdge(matrix, tR++, tC++, dR --, dC--);
        }
    }

    public static void printEdge(int[][] martix, int tR, int tC, int dR, int dC) {
        // times就是总的数组
        int times = dC - tC;
        int tmp = 0;
//        for (int i = 0; i != times ; i++) {
//            // 一次循环就一组占据调整, 进行数组的旋转,使用的是顺时针的旋转
//            tmp = martix[tR][tC + i];
//            martix[tR][tC + i] = martix[tR + i][dC];
//            martix[tR + i][dC] = martix[dR][dC - i];
//            martix[dR][dC - i] = martix[dR - i][tC];
//            martix[dR - i][tC] = tmp;
//        }
        for (int i = 0; i != times ; i++) {
            // 一次循环就一组占据调整, 进行数组的旋转,使用的是顺时针的旋转
            tmp = martix[tR][tC + i];
            martix[tR][tC + i] = martix[dR - i][tC];
            martix[dR - i][tC] = martix[dR][dC - i];
            martix[dR][dC - i] = martix[tR + i][dC];
            martix[tR + i][dC] = tmp;
        }
    }
}
