package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _695岛屿的最大面积 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0,1,0,0},
                {0,1,1,1,0,0},
                {0,0,0,1,0,0},
                {0,1,1,0,0,0}
        };
        int res = maxAreaOfIsland(grid);
        System.out.println(res);
    }

    static int max = Integer.MIN_VALUE;
    /**
     * dfs问题如果存在岛屿
     * dfs查询
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {
       if (grid == null || grid.length == 0) {
           return 0;
       }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int t = dfs(grid, i, j);
                    if (t > max) {
                        max = t;
                    }
                    print(grid);
                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    private static int dfs(int[][] grid, int i, int j) {
        int result = 1;
        grid[i][j] = 0;
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            result += dfs(grid, i - 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1 ) {
            result += dfs(grid, i, j - 1);
        }
        if (j + 1 <= grid[0].length && grid[i][j + 1] == 1 ) {
            result += dfs(grid, i, j + 1);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1 ) {
            result += dfs(grid, i + 1, j);
        }

        return result;
    }

    public static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=================================");
    }
}
