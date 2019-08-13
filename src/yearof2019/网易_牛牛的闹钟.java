package yearof2019;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author xuzhangwang
 * @date 2019/7/24
 */
public class 网易_牛牛的闹钟 {
    static int min = Integer.MAX_VALUE;
    static int hour = -1;
    static int minute = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N * 2; i++) {
            stack.push(sc.nextInt());
        }
        int time = sc.nextInt();

        int H = sc.nextInt();
        int M = sc.nextInt();
        while (!stack.isEmpty()) {
            int m = stack.pop();
            int h = stack.pop();
            fun(H, M, h, m, time);
        }
        System.out.println(hour + " " + minute);
    }

    private static void fun(int H, int M, int h, int m, int time) {
        if (H < h) {
            return;
        }
        // 直接转换为分钟计算
        int sj = H * 60 + M;
        int nz = h * 60 + m + time;
        if (nz > sj) {
            return;
        } else {
            int res = sj - nz;
            if (res < min) {
                min = res;
                hour = h;
                minute = m;
            }
        }
    }
}
