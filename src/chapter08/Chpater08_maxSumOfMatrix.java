package chapter08;

/**
 * @Auther: xuzhangwang
 * @Description: 给定的一个的矩阵martix， 其中的值有正数，有负数， 0 ，返回子矩阵中最大累加和
 */
public class Chpater08_maxSumOfMatrix {
    public static void main(String[] args) {
        int[][] m = {
                {-90, 48, 78},
                {64, -40, 64},
                {-81, -7, 66}
        };
        int max = maxSumOfMatrix(m);
        System.out.println(max);
    }


    /**
     * 整个过程可以分解成为每一行的最大累加和
     * 关键的地方有两处
     *  1、用求累加数组的最大和的方式得到每一步的最大子矩阵的累加和
     *  2、每一步的累加数组的可以利用前一步求出的累加数组方便的更新得到
     * @param m
     * @return
     */
    public static int maxSumOfMatrix(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int[] s = null; // 累加数组
        for (int i = 0; i != m.length ; i++) {
            // j 控制的行数的变换
            s = new int[m[0].length];
            for (int j = i; j != m.length ; j++) {
                cur = 0;
                for (int k = 0; k != s.length ; k++) {
                    s[k] += m[j][k];
                    cur += s[k];
                    max = Math.max(max, cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }
}
