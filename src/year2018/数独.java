package year2018;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 数独 {
    private static int[][] sudoku = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = sc.nextInt();
            }
        }

        backTrace(0, 0);


    }

    /**
     * 回溯数独算法
     *
     * @param i
     * @param j
     */
    public static void backTrace(int i, int j) {
        // 如果走到了最后的位置的就直接结算结果
        if (i == 8 && j == 9) {
            printMatrix(sudoku);
            return;
        }

        // 如果已经到到达了最后的位置
        if (j == 9) {
            i++;
            j = 0;
        }

        if (sudoku[i][j] == 0) {
            for (int k = 1; k <= 9; k++) {
                // 判断的给i行j列中放1~9的数字判断是否成功
                if (check(i, j, k)) {
                    sudoku[i][j] = k;
                    backTrace(i, j + 1);

                    // 如果不满足的条件就开始回溯
                    sudoku[i][j] = 0;
                }
            }
        } else {
            // 如该位置有数字，直接下一个位置
            backTrace(i, j + 1);
        }
    }

    /**
     * 打印数独数组
     * @param sudoku
     */
    private static void printMatrix(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                if (j == 8) {
                    System.out.print(sudoku[i][j]);
                } else {
                    System.out.print(sudoku[i][j] + " ");
                }

            }
            System.out.println();
        }
    }

    /**
     * 判断某行某列复赋值是否符合规则
     *
     * @param row
     * @param col
     * @param number
     * @return
     */
    private static boolean check(int row, int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == number || sudoku[i][col] == number) {
                return false;
            }
        }

        // 判断小的九宫格是否的有重复
        int rowIndex = row / 3;
        int colIndex = col / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[rowIndex * 3 + i][colIndex * 3 + j] == number) {
                    return false;
                }
            }
        }
        return true;
    }
}
