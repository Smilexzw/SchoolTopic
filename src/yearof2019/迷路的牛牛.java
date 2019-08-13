package yearof2019;

import java.util.Scanner;

/**牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。虽然他手里有一张地图，但是他需要知道自己面向哪个方向，请你帮帮他。
 输入描述:
 每个输入包含一个测试用例。
 每个测试用例的第一行包含一个正整数，表示转方向的次数N(N<=1000)。
 接下来的一行包含一个长度为N的字符串，由L和R组成，L表示向左转，R表示向右转。
 输出描述:
 输出牛牛最后面向的方向，N表示北，S表示南，E表示东，W表示西。
 示例1
 输入
 复制
 3
 LRR
 输出
 * @author xuzhangwang
 * @date 2019/7/24
 */
public class 迷路的牛牛 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] c = str.toCharArray();

        // 牛牛开始向北方
        String way = "N";
        for (int i = 0; i < n; i++) {
            String t = String.valueOf(c[i]);
            if (way.equals("N")) {
                if (t.equals("L")) {
                    way = "W";
                    continue;
                } else {
                    way = "E";
                    continue;
                }
            }
            if (way.equals("W")) {
                if (t.equals("L")) {
                    way = "S";
                    continue;
                } else {
                    way = "N";
                    continue;
                }
            }

            if (way.equals("S")) {
                if (t.equals("L")) {
                    way = "E";
                    continue;
                } else {
                    way = "W";
                    continue;
                }
            }

            if (way.equals("E")) {
                if (t.equals("L")) {
                    way = "N";
                    continue;
                } else {
                    way = "S";
                    continue;
                }
            }
        }
        System.out.println(way);
    }
}
