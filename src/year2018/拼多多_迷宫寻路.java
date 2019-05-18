package year2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 题目描述
 * 假设一个探险家被困在了地底的迷宫之中，要从当前位置开始找到一条通往迷宫出口的路径。
 * 迷宫可以用一个二维矩阵组成，有的部分是墙，有的部分是路。
 * 迷宫之中有的路上还有门，每扇门都在迷宫的某个地方有与之匹配的钥匙，只有先拿到钥匙才能打开门。
 * 请设计一个算法，帮助探险家找到脱困的最短路径。
 * 如前所述，迷宫是通过一个二维矩阵表示的，每个元素的值的含义如下 0-墙，1-路，2-探险家的起始位置，3-迷宫的出口，
 * 大写字母-门，小写字母-对应大写字母所代表的门的钥匙
 * 输入描述:
 * 迷宫的地图，用二维矩阵表示。第一行是表示矩阵的行数和列数M和N
 * 后面的M行是矩阵的数据，每一行对应与矩阵的一行（中间没有空格）。M和N都不超过100, 门不超过10扇。
 * 输出描述:
 * 路径的长度，是一个整数
 * 示例1
 * 输入
 * 复制
 * 5 5
 * 02111
 * 01a0A
 * 01003
 * 01001
 * 01111
 * 输出
 * 复制
 * 7
 */
public class 拼多多_迷宫寻路 {
    static int M, N;
    static char[][] data;
    static List<Character> list;
    static int[] arr;
    static int[][] place;
    public static void main(String[] args) {
        // 使用dfs
//        Scanner sc = new Scanner(System.in);
//        M = sc.nextInt();
//        N = sc.nextInt();
//        sc.nextLine();
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < N; i++) {
//            sb.append(sc.nextLine());
//        }
//        sc.close();
//        data = new char[M][N];
//        char[] chars = sb.toString().toCharArray();
        M = 5;
        N = 5;
        data = new char[M][N];
        data[0][0] = '0';
        data[0][1] = '2';
        data[0][2] = 'a';
        data[0][3] = '1';
        data[0][4] = '1';

        data[1][0] = '0';
        data[1][1] = '1';
        data[1][2] = 'a';
        data[1][3] = '0';
        data[1][4] = 'A';

        data[2][0] = '0';
        data[2][1] = '1';
        data[2][2] = '0';
        data[2][3] = '0';
        data[2][4] = '3';

        data[3][0] = '0';
        data[3][1] = '1';
        data[3][2] = '0';
        data[3][3] = '0';
        data[3][4] = '1';

        data[4][0] = '0';
        data[4][1] = '1';
        data[4][2] = '1';
        data[4][3] = '1';
        data[4][4] = '1';

        place = new int[M][N];
        list = new ArrayList<>();

        dfs(0, 1, 0, list);

    }

    /**
     * 用来模拟
     * @param x
     * @param y
     * @param cnt
     * @param list
     */
    private static void dfs(int x, int y, int cnt, List<Character> list) {
        if (x > M - 1 || x < 0 || y > N - 1 || y < 0) return;
        char c = data[x][y];
        int cur = data[x][y] - 48;
        if (cur == 3) {
            // 到达了终点直接输出当前的步数
            System.out.println(cnt);
            return;
        }
        if (cur == 0) return;



        // 如果当前的位置是一道门, 并且包含了当前的钥匙，就可以往下走
        if (c >= 'A' && c <= 'Z') {
            if (list.contains(Character.toLowerCase(c))) {
                List<Character> remove =  new ArrayList<>();
                remove.add(Character.toLowerCase(c));
                list.removeAll(remove);
                dfs(x + 1, y, cnt + 1, list);
                dfs(x, y + 1, cnt + 1, list);
                dfs(x - 1, y, cnt + 1, list);
                dfs(x , y + 1, cnt + 1, list);
            } else {
                return;
            }
        }

        if (c >= 'a' && c <= 'z') {
            list.add(c);
            dfs(x + 1, y, cnt + 1, list);
            dfs(x, y + 1, cnt + 1, list);
            dfs(x - 1, y, cnt + 1, list);
            dfs(x , y + 1, cnt + 1, list);
        }

        dfs(x + 1, y, cnt + 1, list);
        dfs(x, y + 1, cnt + 1, list);
        dfs(x - 1, y, cnt + 1, list);
        dfs(x , y + 1, cnt + 1, list);

    }
}
