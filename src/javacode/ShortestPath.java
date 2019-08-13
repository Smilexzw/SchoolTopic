package javacode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 *
 0 5 1 0 0 0
 5 0 2 1 0 0
 1 2 0 4 8 0
 0 1 4 0 3 6
 0 0 8 3 0 0
 0 0 0 6 0 0
 * 用堆实现了从一个点到其他点的最短路径
 *
 * @author 李赫元
 */
public class ShortestPath {

    private static int[][] matrix;
    private static int[] minpath;

    /**
     * @param
     */
    public static void shortpath(int i) {
        minpath[i] = 0;

        int curlen = 0;
        PriorityQueue<Node> heap = new PriorityQueue();
        Node cur = new Node(i, 0); // i 代表的是点， len 代表的是起点到i的距离
        heap.add(cur);
        while (!heap.isEmpty()) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[cur.i][j] != 0 && cur.len + matrix[cur.i][j] < minpath[j]) {
                    minpath[j] = cur.len + matrix[cur.i][j];
                    heap.add(new Node(j, minpath[j]));
                }
            }
            cur = heap.poll();
        }

        //打印最短路径结果
        for (int j = 0; j < matrix.length; j++) {
            if (minpath[j] != Integer.MAX_VALUE && j != i) {
                System.out.print("最短路径：");
                System.out.print("节点： "+ (i + 1) + " 到 " + (j + 1) + " 最短距离为:  " + minpath[j]);
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入节点个数:");
        int n = sc.nextInt();
        matrix = new int[n][n];
        System.out.println("请输出节点的邻接矩阵: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        // 存储单源最短路径
        minpath = new int[n];
        for (int i = 0; i < n; i++) {
            minpath[i] = Integer.MAX_VALUE;
        }
        shortpath(2);
        System.out.println(Arrays.toString(minpath));
    }
}


/**
 * 定义拥有自然顺序（Comparable）的节点用于优先队列
 *
 * @author 李赫元
 */
class Node implements Comparable<Node> {
    int i;
    int len;

    public Node(int i, int len) {
        this.i = i;
        this.len = len;
    }

    @Override
    public int compareTo(Node o) {
        int dif = len - o.len;
        if (dif > 0) {
            return 1;
        } else if (dif == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
