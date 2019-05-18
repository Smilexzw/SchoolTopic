package offer;

import java.util.Scanner;

/**
 * 这个问题的就是 斐波那契数列的变体
 *
 * @author: xuzhangwang
 */
public class 矩阵覆盖 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = RectCover(n);
        System.out.println(res);
    }

    public static int RectCover(int target) {
        if (target < 2) return target;
        int pre = 1;
        int res = 2;

        int tmp = 0;

        for (int i = 3; i <= target; i++) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }
}
