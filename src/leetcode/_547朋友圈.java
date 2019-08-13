package leetcode;

/**
 * @author xuzhangwang
 * @date 2019/7/31
 */
public class _547朋友圈 {


    public static void main(String[] args) {
        int[][] m = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        int result = findCircleNum(m);
        System.out.println(result);
    }

    static int res = 0;

    /**
     * dfs搜索一遍
     * @param M
     * @return
     */
    public static int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        // 使用vis数组判断每个节点，如果未被访问到，则朋友圈+1
        boolean[] visited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }

    private static void dfs(int[][] m, boolean[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && !visited[i]) {
                visited[j] = true;
                dfs(m, visited, j);
            }
        }
    }
}
