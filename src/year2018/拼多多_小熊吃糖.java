package year2018;

import java.util.*;

/**
 * 有n只小熊，他们有着各不相同的战斗力。每次他们吃糖时，会按照战斗力来排，战斗力高的小熊拥有优先选择权。
 * 前面的小熊吃饱了，后面的小熊才能吃。每只小熊有一个饥饿值，每次进食的时候，小熊们会选择最大的能填饱自己当前饥饿值的那颗糖来吃，可能吃完没饱会重复上述过程，但不会选择吃撑。
 * 现在给出n只小熊的战斗力和饥饿值，并且给出m颗糖能填饱的饥饿值。
 * 求所有小熊进食完之后，每只小熊剩余的饥饿值。
 * <p>
 * <p>
 * 输入描述:
 * 第一行两个正整数n和m，分别表示小熊数量和糖的数量。（n <= 10, m <= 100）
 * 第二行m个正整数，每个表示着颗糖能填充的饥饿值。
 * 接下来的n行，每行2个正整数，分别代表每只小熊的战斗力和当前饥饿值。
 * 题目中所有输入的数值小于等于100。
 * 输出描述:
 * 输出n行，每行一个整数，代表每只小熊剩余的饥饿值。
 * 示例1
 * 输入
 * 复制
 * 2 5
 * 5 6 10 20 30
 * 4 34
 * 3 35
 * 输出
 * 复制
 * 4
 * 0
 * 说明
 * 第一只小熊吃了第5颗糖
 * 第二只小熊吃了第4颗糖
 * 第二只小熊吃了第3颗糖
 * 第二只小熊吃了第1颗糖
 *
 * @author: xuzhangwang
 */
public class 拼多多_小熊吃糖 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] candy = new int[m];
        for (int i = 0; i < candy.length; i++) {
            candy[i] = sc.nextInt();
        }
        Arrays.sort(candy);

        int[][] bears = new int[n][3]; // 熊的战斗力，最后一行为索引，用于最后的排序输出
        for (int i = 0; i < n; i++) {
            bears[i][0] = sc.nextInt();
            bears[i][1] = sc.nextInt();
            bears[i][2] = i;
        }
        Arrays.sort(bears, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });


        for (int i = 0; i < n; i++) { // n个小熊
            for (int j = m - 1; j >= 0; j--) { // 糖果
                if (candy[j] == -1) {  // 当前不能吃
                    continue;
                }
                // 吃下当前的能吃下最大值,但是不会吃撑
                if (bears[i][1] >= candy[j]) {
                    bears[i][1] -= candy[j];
                    candy[j] = -1;
                }
            }
        }

        Arrays.sort(bears, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(bears[i][1]);
        }
    }
}
