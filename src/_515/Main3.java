package _515;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class Main3 {
    public static char[][] grid;
    public static int min = Integer.MAX_VALUE;

    public static int[][] next = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new char[n][n];

        sc.nextLine();
        for (int i = 0; i < grid.length; i++) {
            char[] c = sc.nextLine().toCharArray();
            for (int j = 0; j < c.length; j++) {
                grid[i][j] = c[j];
            }
        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '@') {
                    bfs(i, j);
                }

            }
        }
        System.out.println(min);


    }


    private static void bfs(int i, int j) {
        int[][] dist = new int[grid.length][grid[0].length];

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            // 开始上下左右走路

            if (grid[point.getX()][point.getY()] == '*') {
                if (min > dist[point.getX()][point.getY()]) {
                    min = dist[point.getX()][point.getY()];
                    return;
                }
            }

            for (int k = 0; k < 4; k++) {
                int tx = i + next[k][0];
                int ty = j + next[k][1];


                if (tx >= 0 && tx < grid.length && ty >= 0 && ty < grid[0].length && grid[tx][ty] == '.' && dist[i][j] == 0) {
                    queue.add(new Point(tx, ty));
                    dist[tx][ty] = dist[point.getX()][point.getY()] + 1;
                }

            }
        }

        for (int k = 0; k < dist.length; k++) {
            for (int l = 0; l < dist[0].length; l++) {
                System.out.print(dist[k][l] + " ");
            }
            System.out.println();
        }
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
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