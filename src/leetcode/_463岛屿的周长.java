package leetcode;

import java.util.Arrays;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。

 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。

 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

  

 示例 :

 输入:
 [[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

 输出: 16

 解释: 它的周长是下面图片中的 16 个黄色的边：


 在真实的面试中遇到过这道题？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/island-perimeter
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _463岛屿的周长 {

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        int res = islandPerimeter(grid);
        System.out.println(res);

    }
    /**
     * 先将数组的扩大
     * 在将岛屿周围的填成-1
     * dfs遍历填充
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    // 如果之前出现过相邻的就删除2
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        res -= 2;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        res -= 2;
                    }
                }
            }
        }
        return res;
    }
}
