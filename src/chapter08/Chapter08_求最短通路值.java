package chapter08;

import com.sun.org.apache.bcel.internal.util.ClassQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: xuzhangwang
 * @Description: 用一个整形矩阵matrix表示一个网络， 1代表有路，0代表无路，每一个位置只要不要越界， 都有上下左右四个方向，
 * 求从左上角到右下角的最短距离
 *
 *
 * 此题目类似于之前做的解救小哈和滴滴面试的地下迷宫
 */
public class Chapter08_求最短通路值 {
    // 定义所用的最小路径
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] m = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 1, 1}
        };
        int[][] book = new int[m.length][m[0].length];
        // 本道题目的结果的是算上第一个位置， 所以开始设置step的值为1
        dfs(m, book, 0,  0, 1);
        System.out.println(min);


        int result = minPath(m);
        System.out.println(result);
    }


    /**
     * 返回的最短距离的值的
     * 使用宽度优先即可， 如果矩阵大小为N x M 本文的提供给方法时间复杂度为O (N x M) 具体的过程如下
     * 1、开始生成map矩阵，map【i】【j】 的含义是从（0， 0) 位置走到（i， j）位置最短的路径值。然后将左上角位置（0，0）的行坐标与列坐标的放入的行队列的rQ
     * 和列队列cQ
     * 2、不断从队列弹出一个位置（r，c）然后看这个位置的上下左右的四个位置哪些在matrix上的值为1，这些都是可以走的位置
     * 3、将那些能走的位置设置好在各自在map中的值， 即map【r】【c】 + 1.同时将这些位置加入到rQ和cQ中，用队列完成宽度优先的遍历
     * 4、在步骤3中，如果一个位置之前走过，就不要重复走， 这个歌逻辑可以根据一个位置在map中的值来确定即可， 比如map【i】【j】 != 0 就可以指导这个位置之前走过
     * 5、一直重复步骤2~4，直到遇到右下角位置，说明已经找到终点， 返回终点在map中的值己可， 如果rQ和cQ已经为空的都没有遇到终点位置，说明不存在这样一路
     * @param m
     * @return
     *
     */
    public static int minPath(int[][] m) {
        // 判断一下哪些情况是不能得到结果
        if (m == null || m.length == 0 || m[0].length == 0 || m[0][0] != 1 || m[m.length - 1][m[0].length - 1] != 1) {
            return 0;
        }
        // TODO 这里使用的是深度搜索进行问题的解决
        int res = 0;
        int[][] map = new int[m.length][m[0].length];
        map[0][0] = 1;
        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> cQ = new LinkedList<>();
        rQ.add(0);
        cQ.add(0);
        int r = 0;
        int c = 0;
        while (!rQ.isEmpty()) {
            r = rQ.poll();
            c = cQ.poll();
            // 判断是否走右下角的位置
            if (r == m.length - 1 && c == m[0].length - 1) {
                return map[r][c];
            }
            walkTo(map[r][c], r - 1, c, m, map, rQ, cQ);  // up
            walkTo(map[r][c], r + 1, c, m, map, rQ, cQ);  // dowm
            walkTo(map[r][c], r, c - 1, m, map, rQ, cQ);  // left
            walkTo(map[r][c], r, c + 1, m, map, rQ, cQ);  // right
        }
        return 0;
    }

    public static void walkTo(int pre, int toR, int toC, int[][] m, int[][] map, Queue<Integer> rQ, Queue<Integer> cQ) {
        if (toR < 0 || toR == m.length || toC < 0 || toC == m[0].length || map[toR][toC] != 0 || m[toR][toC] != 1) return;
        map[toR][toC] = pre + 1;
        rQ.add(toR);
        cQ.add(toC);
    }

    /**
     * 使用深度搜索解决此类问题,枚举四类走法
     * 右下左上 int[][] next = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} }
     * @param x
     * @param y
     * @param step
     */
    public static void dfs(int[][] m, int[][] book, int x, int y, int step) {
        int[][] next = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        int tx = 0, ty = 0;
        // 判断是否达到了位置, 如果到达了右下角的位置，就判断当前的步数是否为最小
        if (x == m.length - 1 && y == m[0].length - 1) {
            if(step < min) {
                min = step;
            }
            return;
        }

        // 开始枚举的四种走法
        for (int k = 0; k < next.length; k++) {
            // 计算下一个坐标
            tx = x + next[k][0];
            ty = y + next[k][1];
            // 判断该店是否越界
            if (tx < 0 || tx > m.length - 1 || ty < 0 || ty > m[0].length - 1) continue;

            // 判断该点是否为障碍物， 或则已经走过, 如果不是障碍点和已经走过的点就代表可以继续走下去
            if (m[tx][ty] == 1 && book[tx][ty] == 0) {
                book[tx][ty] = 1;
                dfs(m, book, tx, ty, step + 1);
                // 如果执行了这一步骤就代表当前已经开始回溯
                book[tx][ty] = 0;
            }

        }

    }

}
