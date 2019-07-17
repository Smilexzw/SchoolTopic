package _0710;

import java.util.Scanner;

/**
 *
 假设你正在爬一个N级的楼梯, 每步可以选择上1级或者2级台阶, 总共有多少种爬法?

 * @author xuzhangwang
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = fun(n);
        System.out.println(res);
    }

    public static int fun(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return fun(n - 1) + fun(n -2); 
    }
}
