package leetcode;

/**
 * @author: xuzhangwang
 */
public class _036有效的数独 {
    public static void main(String[] args) {
        char[][] borid= {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        boolean res = isValidSudoku(borid);
        System.out.println(res);

    }


    /**
     * 有效的数独
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (!isValidCol(board, i)) {
                return false;
            }
        }


        for (int i = 0; i < 7; i += 3) {
            for (int j = 0; j < 7; j += 3) {
                if (!isValidSquare(board, i, j)) {
                    return false;
                }
            }
        }


        return true;
    }

    /**
     * 验证小矩阵中的数据是否合法
     * @param board
     * @param row
     * @param col
     * @return
     */
    private static boolean isValidSquare(char[][] board, int row, int col) {
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = 1;
        }

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (board[i][j] != '.') {
                    nums[Character.getNumericValue(board[i][j] - 1)]--;
                }
            }
        }

        for (int i : nums) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 验证每一列是否摆放合法
     * @param board
     * @param col
     * @return
     */
    private static boolean isValidCol(char[][] board, int col) {
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = 1;
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.') {
                nums[Character.getNumericValue(board[i][col]) - 1]--;
            }
        }

        for (int i : nums) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 验证每一行是否摆放合法
     * @param board
     * @param index
     * @return
     */
    private static boolean isValidRow(char[][] board, int index) {
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = 1;
        }

        for (int j = 0; j < 9; j++) {
            if (board[index][j] != '.') {
                nums[Character.getNumericValue(board[index][j]) - 1]--;
            }
        }

        for (int i : nums) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
