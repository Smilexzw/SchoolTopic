package offer;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 求和公式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = Sum_Solution(n);
        System.out.println(res);
    }

    public static int Sum_Solution(int n) {
        if (n == 1) return 1;
        return Sum_Solution(n - 1) + n;
    }
}
