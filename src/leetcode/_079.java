package leetcode;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class _079 {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        boolean res = exist(board, "ABCB");
        System.out.println(res);
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean exist(char[][] borad, int x, int y, String word, int start) {
        // 如果当前的start大于word长度说明之前的步骤都是正确的
        if (start >= word.length()) return true;
        if (x < 0 || x >= borad.length || y < 0 || y >= borad[0].length) return false;
        if (borad[x][y] == word.charAt(start++)) {
            char c = borad[x][y];
            borad[x][y] = '#';
            boolean res = exist(borad, x + 1, y, word, start) ||
                    exist(borad, x, y - 1, word, start) ||
                    exist(borad, x - 1, y, word, start) ||
                    exist(borad, x, y + 1, word, start);

            // 进行回溯
            borad[x][y] = c;
            return res;
        }
        return false;
    }

}
