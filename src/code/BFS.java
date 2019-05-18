package code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: xuzhangwang
 * @Description: 迷宫问题
 */
public class BFS {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };
        bfs(grid);

    }

    static class Node {
        int r;
        int c;
//        int k; // 第几波被访问的
        Node(int r, int c) {
            this.c = c;
            this.r = r;
//            this.k = k;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }
    }

    private static void bfs(int[][] grid) {
        int[][] distance = new int[5][5];


        // 记录的移动的四个方位
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // 如果达到了终点
            if (node.getR() == 4 && node.getC() == 4) break;
            for (int i = 0; i < 4; i++) {
                int x = node.getR() + dx[i];
                int y = node.getC() + dy[i];
                // 判断越界，是否走过，障碍判断
                if (x >= 0 && y >= 0 && x < 5 && y < 5 &&
                        grid[x][y] != 1 && distance[x][y] == 0) {
                    queue.add(new Node(x, y));
                    distance[x][y] = distance[node.getR()][node.getC()] + 1;
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                System.out.print(distance[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(distance[4][4]);
    }

}
