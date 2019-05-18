package code;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 岛屿的个数 {
    static int m;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            char[] chars = sc.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                grid[i][j] = chars[j];
            }
        }

        int res = numIslands(grid);
        System.out.println(res);
    }   

    /**
     * 使用dfs进行解决
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {
        int res = 0;
        m = grid.length;
        if (m == 0) return 0;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') return;
        // 对小岛进行合并
        grid[i][j] = '0';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }


}
