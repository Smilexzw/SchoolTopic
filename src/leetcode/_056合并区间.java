package leetcode;

import java.util.*;

/**
 * @author xuzhangwang
 * @date 2019/7/29
 */
public class _056合并区间 {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{5,4}, {3, 6},{8,10},{15,18}};
        int[][] res = merge(intervals);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] merge(int[][] m) {
        if (m == null || m.length <= 1) {
            return m;
        }
        Arrays.sort(m, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int n = m.length;
        int i = 0;
        List<int[]> list = new ArrayList<>();
        while (i < n) {
            int left = m[i][0];
            int right = m[i][1];
            while (i < n - 1 && right >= m[i + 1][0]) {
                right = Math.max(right, m[i + 1][1]);
                i++;
            }
            // 如果上述while循环结束代表合并结束
            int[] arr = new int[] {left, right};
            list.add(arr);
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
