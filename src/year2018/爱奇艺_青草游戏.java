package year2018;

import java.util.Scanner;

/**
 * 题目描述
 * 牛牛和羊羊都很喜欢青草。今天他们决定玩青草游戏。
 * 最初有一个装有n份青草的箱子,牛牛和羊羊依次进行,牛牛先开始。
 * 在每个回合中,每个玩家必须吃一些箱子中的青草,所吃的青草份数必须是4的x次幂,比如1,4,16,64等等。
 * 不能在箱子中吃到有效份数青草的玩家落败。假定牛牛和羊羊都是按照最佳方法进行游戏,请输出胜利者的名字。
 * 输入描述:
 * 输入包括t+1行。
 * 第一行包括一个整数t(1 ≤ t ≤ 100),表示情况数.
 * 接下来t行每行一个n(1 ≤ n ≤ 10^9),表示青草份数
 * 输出描述:
 * 对于每一个n,如果牛牛胜利输出"niu",如果羊羊胜利输出"yang"。
 * 示例1
 * 输入
 * 复制
 * 3
 * 1
 * 2
 * 3
 * 输出
 * 复制
 * niu
 * yang
 * niu
 *
 *
 * 4 niu
 * 5 拿1或则4都是输了   yang
 * 6 拿1,就剩下五,直接赢了 牛
 * 7 那4,剩下3, niu赢了
 * 8 拿1身下7,牛赢了
 * @author: xuzhangwang
 */
public class 爱奇艺_青草游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- != 0) {
            int in = sc.nextInt();
            System.out.println( (in % 5 == 0|| in % 5 == 2) ? "yang" : "niu");
        }
        return;
    }
}
