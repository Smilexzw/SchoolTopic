package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。

 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

 示例 1:

 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 输出: [[1,5],[6,9]]
 示例 2:

 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 输出: [[1,2],[3,10],[12,16]]
 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/insert-interval
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _057插入区间 {

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[]  newIterval = {4, 8};
        int[][] m = insert(intervals, newIterval);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 原理类似于合并区间，先插入，在合并区间
     * @param intervals
     * @param newInterval
     * @return
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null) {
            return intervals;
        }
        int len = intervals.length;
        int[][] m = new int[len + 1][2];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                m[i][j] = intervals[i][j];
            }
        }
        m[len] = newInterval;

        Arrays.sort(m, (o1, o2) -> o1[0] - o2[0]);

        List<int[]> list = new ArrayList<>();
        int n = m.length;
        int i = 0;
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
        int[][] res = new int[list.size()][2];
        i = 0;
        for (int[] ints : list) {
            res[i++] = ints;
        }
        return res;
    }
}
