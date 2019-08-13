package yearof2019;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xuzhangwang
 * @date 2019/8/10
 */
public class 贝壳_朋友圈 {
    public static void main(String[] args) {
        // 采用dfs搜索
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] dp = new int[n][n];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            dp[a][b] = dp[b][a] = 1;
        }




        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("===================");
        int index = 2;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == 1) {
                    dfs(dp, i ,j, index);
                    index++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] == 0) continue;
                if (!map.containsKey(dp[i][j])) {
                    map.put(dp[i][j], 1);
                } else {
                    map.put(dp[i][j], map.get(dp[i][j]) + 1);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (Integer t : map.values()) {
            max = Math.max(max, t);
        }

        if (max > n) {
            System.out.println(n);
        } else {
            System.out.println(max / 2);
        }
    }

    private static void dfs(int[][] dp, int i, int j, int index) {
        if (i < 0 || i >= dp.length || j < 0 || j >= dp[0].length || dp[i][j] != 1) {
            return;
        }

        dp[i][j] = index;
        dfs(dp, i, j + 1, index);
        dfs(dp, i, j - 1, index);
        dfs(dp, i + 1, j, index);
        dfs(dp, i - 1, j, index);
        dfs(dp, i + 1, j + 1, index);
        dfs(dp, i + 1, j - 1, index);
        dfs(dp, i - 1, j + 1, index);
        dfs(dp, i - 1, j - 1, index);
        return;
    }
}
