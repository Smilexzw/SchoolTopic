package year2018;

        import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 搜狐_回文数组 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        sc.close();
//
//        // dp[i][j]: 表示a[i],...,a[j]中的回文子序列的最大和
//
//        Integer[][] dp = new Integer[n][n];
//
//        int res = helper(arr, dp, 0, n - 1);
//        System.out.println(res);
//
//    }
//
//    /**
//     * 要求输出最小
//     * @param arr
//     * @param dp
//     * @param i
//     * @param j
//     * @return
//     */
//    private static int helper(int[] arr, Integer[][] dp, int i, int j) {
//        if (i > j) {
//            return 0;
//        }
//
//        if (i == j) {
//            return arr[i];
//        }
//
////        if (dp[i][j] != null) {
////            return dp[i][j];
////        }
//
//        if (arr[i] == arr[j]) {
//            return 2 * arr[i] + helper(arr, dp, i + 1, j - 1);
//        } else {
//            return Math.min((2 * arr[i] + helper(arr, dp, i + 1, j)),
//                    (2 * arr[j] + helper(arr, dp, i, j - 1)));
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2 * arr[i];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] + 2 * arr[i], dp[i][j - 1] + 2 * arr[j]);
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j] + "\t");
//            }
//            System.out.println();
//        }

        // dp[i][j] 表示i~j之间的最小和
        System.out.println(dp[0][n - 1]);
    }

}
