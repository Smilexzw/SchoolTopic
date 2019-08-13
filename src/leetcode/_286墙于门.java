package leetcode;

import java.util.*;

/**
 * You are given a m x n 2D grid initialized with these three possible values.

 -1 - A wall or an obstacle.

 0 - A gate.

 INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647. Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

 For example, given the 2D grid:

 INF  -1  0  INF
 INF INF INF  -1
 INF  -1 INF  -1
 0    -1 INF  INF
 After running your function, the 2D grid should be:

 3  -1   0   1
 2   2   1  -1
 1  -1   2  -1
 0  -1   3   4
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _286墙于门 {

    public static void main(String[] args) {
        int[][] m = {
                {Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}
        };
        wallAdnGates(m);
        for (int[] ints : m) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * bfs搜索room，-1代表的墙，0代表的是门
     * @param room
     */
    public static void wallAdnGates(int[][] room) {
        if (room == null || room.length == 0) return;
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[0].length; j++) {
                // 如果遇到一个门就，就从这个门开始bfs，标联通的节点到自己的距离
                if (room[i][j] == 0) bfs(room, i, j);
            }
        }
    }

    private static void bfs(int[][] room, int i, int j) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * room[0].length + j);
        int dist = 0;
        // 用一个集合标记走过的点
        Set<Integer> visited = new HashSet<>();
        visited.add(i * room[0].length + j);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Integer cur = queue.poll();
                int row = cur / room[0].length;
                int col = cur % room[0].length;
                // 选取之前标记的值和当前距离的较小值
                room[row][col] = Math.min(room[row][col], dist);
                int up = (row - 1) * room[0].length + col;
                int down = (row + 1) * room[0].length + col;
                int left = cur - 1;
                int right = cur + 1;
                if (row > 0 && room[row - 1][col] > 0 && !visited.contains(up)) {
                    queue.offer(up);
                    visited.add(up);
                }
                if (row < room.length - 1 && room[row + 1][col] > 0 && !visited.contains(down)) {
                    queue.offer(down);
                    visited.add(down);
                }
                if (col > 0 && room[row][col - 1] > 0 && !visited.contains(left)) {
                    queue.offer(left);
                    visited.add(left);
                }
                if (col < room[0].length - 1 && room[row][col + 1] > 0 && !visited.contains(right)) {
                    queue.offer(right);
                    visited.add(right);
                }
            }
            dist++;
        }
    }
}
