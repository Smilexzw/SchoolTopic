package leetcode;

/**
 * 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。

 你们是聪明人，每一步都是最优解。 编写一个函数，来判断你是否可以在给定石头数量的情况下赢得游戏。

 示例:

 输入: 4
 输出: false
 解释: 如果堆中有 4 块石头，那么你永远不会赢得比赛；
      因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/nim-game
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _292Nim博弈 {
    public boolean canWinNim(int n) {
        // 评论大神说巴什博弈
        // n % (m + 1) != 0 则先手一定会赢
        return n % 4 != 0;
    }
}
