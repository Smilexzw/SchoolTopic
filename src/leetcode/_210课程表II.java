package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _210课程表II {

    public static void main(String[] args) {
        int n = 4;
        int[][] m = {{1,0},{2,0},{3,1},{3,2}};
        canFinish(n, m);
    }


    public static int[] canFinish(int numCourses, int[][] prerequisites) {
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
                        queue.add(p[0]);
                    }
                }
            }
        }
        int[] res = new int[list.size()];
        if (list.size() == numCourses) {

            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
        } else {
            return new int[0];
        }
        return res;
    }



}
