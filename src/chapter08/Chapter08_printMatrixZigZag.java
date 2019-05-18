package chapter08;

/**
 * @Auther: xuzhangwang
 * @Title: "之"字形打印矩阵
 * @Description: 给定一个矩阵martix，按照“之”的字形的方式打印这个矩阵
 */
public class Chapter08_printMatrixZigZag {
    public static void main(String[] args) {
        int[][] martix = { {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13,14,15,16}
        };
        printMatrixZigZag(martix);
    }

    /*
        给定一个二维的数组，要求打印出来这个之字形的方式，按照一下的方式
        还是初始化上坐标:(tR,tC)开始按照tC++，一直到达第一行的最右边
        初始化下坐标(dR, dC)，开始按照dR++，一直到达第一列的最下边
        同时让（tR，tC）（dR， dC）移动，每次移动形成的对角线打印即可
        上次是从上而下，这次就从下而上
     */
    public static void printMatrixZigZag(int[][] m) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = m.length - 1;
        int endC = m[0].length - 1;
        boolean fromUp = false;
        while (tR != endR + 1) {
            pringLevel(m, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void pringLevel(int[][] m, int tR, int tC, int dR, int dC, boolean fromUp) {
        if (fromUp) {
            // 如果是真的就从上而下开始打印
            while (tR != dR + 1)
            System.out.print(m[tR++][tC--] + " ");
        } else {
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }
}
