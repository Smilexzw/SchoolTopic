package yearof2019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class Code2 {
    static int[][] next = {
            {1, 0},
            {0, -1},
            {-1, 0},
            {0, 1},
            {1, -1},
            {1, 1},
            {-1, -1},
            {-1, 1}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int k = sc.nextInt();
            bfs(x, y, k);
        }
    }

    private static void bfs(int x, int y, int k) {
        int[][] distance = new int[x + 1][y + 1];

        int[] dx = {1, 0, -1, 0, 1, -1, 1, -1};
        int[] dy = {0, 1, 0, -1, 1, -1, -1, 1};

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // 如果到达终点
            if (node.getX() == x && node.getY() == y) break;
            for (int i = 0; i < 8; i++) {
                int tx = node.getX() + dx[i];
                int ty = node.getY() + dy[i];
                // 判断越界
                if (tx >= 0 && ty >= 0 && tx <= x && ty <= y && distance[tx][ty] == 0) {
                    queue.add(new Node(tx, ty));
                    distance[tx][ty] = distance[node.getX()][node.getY()] + 1;
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length; j++) {
                System.out.print(distance[i][j] + "\t");
            }
            System.out.println();
        }


    }


}

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

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
}