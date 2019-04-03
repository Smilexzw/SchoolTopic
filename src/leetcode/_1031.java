package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: xuzhangwang
 * @Description: 1031. 飞地的数量  显示英文描述
 * 用户通过次数 2
 * 用户尝试次数 2
 * 通过次数 2
 * 提交次数 4
 * 题目难度 Medium
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 * <p>
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 * <p>
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：
 * 有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 示例 2：
 * <p>
 * 输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：
 * 所有 1 都在边界上或可以到达边界。
 * <p>
 * [[0,0,0,1,1,1,0,1,0,0],[1,1,0,0,0,1,0,1,1,1],[0,0,0,1,1,1,0,1,0,0],[0,1,1,0,0,0,1,0,1,0],[0,1,1,1,1,1,0,0,1,0],[0,0,1,0,1,1,1,1,0,1],[0,1,1,0,0,0,1,1,1,1],[0,0,1,0,0,1,0,1,0,1],[1,0,1,0,1,1,0,0,0,0],[0,0,0,0,1,1,0,0,0,1]]
 */
public class _1031 {
    public static void main(String[] args) {
        int[][] A = {
                {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
                {0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}};
//        int[][] A = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}};
        int res = numEnclaves(A);
        System.out.println(res);
    }


    // 使用bfs开始查找
    public static int numEnclaves(int[][] A) {
        if (A == null || A[0] == null || A[0].length == 0 || A.length == 0) return 0;
        boolean[][] b = new boolean[A.length][A[0].length];
        Queue<Node1> queue = new LinkedList<>();
        // 如果当前的位置为1，并且当前的位置为true这个位置就是合法的
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i == 0 || j == 0 || i == A.length - 1 || j == A[0].length - 1) {
                    if (A[i][j] == 1) {
                        queue.add(new Node1(i, j));
                        b[i][j] = true;
                    }
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        while (!queue.isEmpty()) {
            Node1 node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = node.getX() + dx[i];
                int y = node.getY() + dy[i];
                if (x < 0 || x >= A.length || y < 0 || y >= A[0].length) continue;
                if (A[x][y] == 0 || b[x][y]) continue; // 如果下一个位置为false就不可以继续下走
                queue.add(new Node1(x, y));
                b[x][y] = true;
            }
        }

        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1 && b[i][j] == false) {
                    res++;
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
        return res;
    }
}

class Node1 {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Node1(int x, int y) {
        this.x = x;
        this.y = y;
    }
}