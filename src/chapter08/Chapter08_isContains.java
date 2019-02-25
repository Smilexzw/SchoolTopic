package chapter08;

/**
 * @Auther: xuzhangwang
 * @Description: 在行和列都排列好的矩阵中找数
 */
public class Chapter08_isContains {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 5},
                {2, 3, 4, 7},
                {4, 4, 4, 4},
                {5, 7, 7, 9}
        };
        boolean tmp = isContains(matrix, 5);
        System.out.println(tmp);
    }

    public static boolean isContains(int[][] matrix, int x) {
        int curR = matrix.length - 1;
        int curC = 0;
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        while (curR >= 0 && curC <= col) {
            if (matrix[curR][curC] == x) {
                return true;
            } else if (matrix[curR][curC] > x) {
                curR--;
            } else {
                curC++;
            }
        }
        return false;
    }
}
