package leetcode;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:5024. 除数博弈  显示英文描述
 * 用户通过次数 0
 * 用户尝试次数 0
 * 通过次数 0
 * 提交次数 0
 * 题目难度 Easy
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 */
public class _5024 {
    public static void main(String[] args) {
        // 这个类似取球博弈问题，将子问题交给的对面的去做
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean b = divisorGame(N);
        System.out.println(b);
    }

    public static boolean divisorGame(int N) {
        return dfs(N, 0, 0);
    }

    /**
     * me和you对应的是取球的次数的
     * 如果me的次数的更多就赢了
     * 如果相等的就相当与是me最后去球，则会输掉比赛
     * @param N
     * @param me
     * @param you
     * @return
     */
    public static boolean dfs(int N, int me, int you) {
        if (N <= 1) {
            // 如果小于1的话就无法继续进行，就结算
            if (me == you) return false;
            if (me > you) return true;
        }

        for (int i = 1; i < N; i++) {
            if (N > 1) {
                boolean res = dfs(N - i, you, me + 1);
                if (res == false) return false;
                else if (res == true) return true;
            }
        }
        return true;
    }
}
