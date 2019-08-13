package leetcode;

/**
 * @author xuzhangwang
 * @date 2019/7/31
 */
public class _787k次中转最便宜的航班 {

    static int MAX = Integer.MAX_VALUE;
    static int[][] G = new int[100][100];
    static int[] d = new int[100];
    static int[] path = new int[100];
    static boolean[] visit = new boolean[100];
    static int N = 0;
    static int res = MAX;
    static int times = 0;

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                G[i][j] = MAX;
            }
        }
        N = n;
        times = k;
        for (int[] flight : flights) {
            G[flight[0]][flight[1]] = flight[2];
        }
        dfs(src, dst, 0, 0);
        return res == MAX ? -1 : res;
    }

    private static void dfs(int now, int dst, int cost, int k) {
        if (k - 1 > times) return;
        if (now == dst) {
            res = cost;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visit[i] == false &&  cost + G[now][i] < res) {
                visit[i] = true;
                dfs(i, dst, cost + G[now][i] , k + 1);
                visit[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int n = 3;
        int[][] edge = {
                {0, 1, 100}, {1, 2, 100}, {0, 2, 500}
        };
        int src = 0;
        int dst = 2;
        int k = 1;
        int res = findCheapestPrice(n, edge, src, dst, k);
        System.out.println(res);

    }
}
