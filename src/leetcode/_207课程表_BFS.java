package leetcode;

import java.util.*;

/**
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _207课程表_BFS {
    public static void main(String[] args) {
        int n = 4;
        int[][] m = {{1,0},{2,0},{3,1},{3,2}};
        boolean res = canFinish(n, m);
    }

    /**
     * 使用拓扑排序，判断图中是否有环路
     * 如果最后没有入度为0 的则有换
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        // 存储所有入度为0的节点
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        // 存储的拓扑的结构
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer num = queue.poll();
            list.add(num);
            for (int[] p : prerequisites) {
                if (p[1] == num) {
                    indegree[p[0]]--;
                    if (indegree[p[0]] == 0) {
                        // 入度
                        queue.offer(p[0]);
                    }
                }
            }
        }
        System.out.println(list.toString());
        return list.size() == numCourses;
    }


}
