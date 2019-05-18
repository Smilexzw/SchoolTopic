package offer;

/**
 * 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 *
 * @author: xuzhangwang
 */
public class 矩阵中的路劲 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        char[] grid = {'a', 'b', 't', 'g', 'c', 'f', 'c', 's', 'j', 'd', 'e', 'h'};

        int rows = 3;
        int cols = 4;
        char[] str = "bfce".toCharArray();
        boolean res = hasPath(grid, rows, cols, str);
        System.out.println(res);


    }

    /**
     * 从矩阵的row，cols位置开始搜索
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        // 标志位置，初始化为哦false
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, flag, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, boolean[] flag, int k) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == true) {
            return false;
        }

        // 如果走到最后的位置，说明匹配成功
        if (k == str.length - 1) {
            return true;
        }

        flag[index] = true;

        // 开始走下一个位置，如果全部满足就开始回溯
        if (helper(matrix, rows, cols, i + 1, j, str, flag, k + 1)
                || helper(matrix, rows, cols, i, j - 1, str, flag, k + 1)
                || helper(matrix, rows, cols, i - 1, j, str, flag, k + 1)
                || helper(matrix, rows, cols, i, j + 1, str, flag, k + 1)) {
            return true;
        }

        flag[index] = false;

        return false;
    }

}
