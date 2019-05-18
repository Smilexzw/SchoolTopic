package exam;

/**
 * @Auther: xuzhangwang
 * @Description:
 * 3 6
.S#..E
.#.0..
......
 */
public class 头条第三次模拟_Code2 {
    static int firstmin = Integer.MAX_VALUE;
    public static int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int[][] place;
    public static char[][] xz;
    public static void main(String[] args) {

        char[][] grid = {
                {'.', 'S', '#', '.', '.', 'E'},
                {'.', '#', '.', '0', '.', '.'},
                {'.', '.', '.', '.', '.', '.'}
        };

        xz = grid;

        place = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'S') {
                    dfs(i, j, 0, grid); // 开始bfs寻找
                }
            }
        }
        System.out.println(firstmin);
    }

    /*
        bfs开始寻找结果
     */
    public static void dfs(int x, int y, int step, char[][] grid) {
        int tx = 0;
        int ty = 0;

        // 开始寻找棋盘中0的位置
        if (grid[x][y] == '0') {
            if (step < firstmin) {
                firstmin = step;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            tx = x + next[i][0];
            ty = y + next[i][1];
            if (tx < 0 || ty < 0 || tx > grid.length - 1 || ty > grid[0].length - 1) continue;
            // 如果当前下一个位置是箱子的话，开始推箱子

            if (grid[tx][ty] != '#' && place[tx][ty] != 1) {
                place[x][y] = 1;
                dfs(tx, ty, step + 1, grid);
                place[x][y] = 0;
            }

        }

    }
}
