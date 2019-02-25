package yearof2017;

import java.util.Arrays;
import java.util.Scanner;

public class 网易_Fibonacci数列 {

    public static int getMinCount(int n) {
        int[] opt = new int[n];
        opt[0] = 0;
        opt[1] = 1;
        for (int i = 2; i < opt.length; i++) {
            opt[i] = opt[i - 1] + opt[i -2];
        }
        System.out.println(Arrays.toString(opt));
        return 0;
    }

    public static int getMinFB(int n) {
        // 使用循环, 边循环边判断当前的数是否大于n 当大于的时候就产生了两个大于当前数的斐波那契数
        int f1 = 0;
        int f2 = 1;
        while (f2 <= n) {
            int tmp = f1 + f2;
            f1 = f2;
            f2 = tmp;
        }
        // 跳出循环表示当前的f2 是大于当前输入进去的数 , 而f2则是由两个斐波那契数相加的
        return Math.min(n - f1, f2 - n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getMinFB(n));
    }
}

