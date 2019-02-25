package yearof2017;

/**
 *
 * @ClassName: 滴滴_地下迷宫
 * @Description: 使用dfs来深度搜索迷宫, 目标从点(0, 0)走到点(0, m-1)使用的体力值最小
 * 迷宫为 n * m的矩阵, 向下走是不花费体力值的, 向右走是要花费1体力值, 向上走是花费3点体力值
 * @author xuzhangwang
 * @date 2018年10月11日
 *
 */
public class 滴滴_地下迷宫 {
    // 定义小青蛙移动的四个方向, 分别是{向右走, 向下走, 向左走, 向上走}下列的数组中的分别表示的走的方向
    final static int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    // 定义向什么方向走花费的体力值
    final static int[] life = {1, 0, 1, 3};
    static int min = Integer.MAX_VALUE;
    static int[][] nums =  { {1, 0, 0, 1},
            {1, 1, 0, 1} ,
            {0, 1, 1, 1},
            {0, 0, 1, 1}
    };
    static int[][] book = new int[nums.length][nums[0].length];
    public static void main(String[] args) {
        book[0][0] = 1;
        dfs(0, 0, 0);
        System.out.println(min);
    }

    /**
     *
     * @Title: dfs
     * @Description: 深度搜索迷宫来查询是否有正确得解
     * @param @param x    当前的点的x坐标
     * @param @param y    当前的点的y坐标
     * @param @param nowlife   当前剩余的体力值
     * @return int   返回类型
     * @throws
     */
    public static void dfs(int x, int y, int nowlife) {
        int tx = 0, ty = 0;
        // 判断是否达到终点了
        if(x == 0 && y == nums[0].length - 1 && nowlife <= 10) {
            // 如果达到终点了但是体力值超出界限也是不行的
            if (nowlife < min) {
                min = nowlife;
            }
            for (int i = 0; i < book.length; i++) {
                for (int j = 0; j < book[0].length; j++) {
                    System.out.print(book[i][j] + "\t");
                }
                System.out.println();
            }
        }
        else {
            // 枚举四种走法
            for (int k = 0; k < 4; k++) {
                tx = x + next[k][0];
                ty = y + next[k][1];
                if(tx < 0 || tx > nums.length - 1 || ty < 0 || ty > nums[0].length - 1) continue;
                if (nums[tx][ty] == 1 && book[tx][ty] == 0 && nowlife + life[k] <= 10) {
                    book[tx][ty] = 1;
                    dfs(tx, ty, nowlife + life[k]);
                    book[tx][ty] = 0;
                }
            }
        }
    }
}
