package chapter04;

/**
 * @Auther: xuzhangwang
 * @Description: 给定数组arr， arr中的所有的值都为正数且不重复。 每个值代表一种面值的货币，每种面值的货币可以使用任意张
 * 在给定一个整数aim代表要找的钱数，求换钱有多少中方法。
 */
public class Chapter04_Coins {
    public static void main(String[] args) {
        int[] arr = {1, 5, 10, 20, 50, 100};
        int aim = 5000;
        int res = coins3(arr, aim);
        System.out.println(res);
    }

    // 使用暴力递归的方法进行解决
    public static int coins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }
    // 使用的是暴力破解的方法
    public static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    // 使用的是动态规划的方法
    public static int coins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) return 0;
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }
        int num = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[arr.length - 1][aim];
    }
}
