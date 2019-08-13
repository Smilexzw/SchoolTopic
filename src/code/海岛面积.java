package code;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 00011
 11011
 10001
 * @author xuzhangwang
 * @date 2019/7/31
 */
public class 海岛面积 {
    static int max = Integer.MIN_VALUE;
    static int k = 2;
    public static void main(String[] args) {
        int[][] m = {{0,0,0,1,1}, {1,1,0,1,1}, {1,0,0,0,1}};
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1) {
                    int t = dfs(m, i, j);
                    k = k + 1;
                    if (t > max) {
                        max = t;
                    }
                }
            }
        }
        System.out.println(max);
        for (int[] ints : m) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int dfs(int[][] m, int i, int j) {
        int res = 1;
        m[i][j] = k;
        if (i - 1 >= 0 && m[i - 1][j] == 1) {
            res += dfs(m, i - 1, j);
        }
        if (j - 1 >= 0 && m[i][j - 1] == 1) {
            res += dfs(m, i, j - 1);
        }
        if (i + 1 < m.length && m[i + 1][j] == 1) {
            res += dfs(m, i + 1, j);
        }
        if (j + 1 < m[0].length && m[i][j + 1] == 1) {
            res += dfs(m, i, j + 1);
        }
        return res;
    }
}
