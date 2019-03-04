package yearof2017;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 * 给定一个正整数，编写程序计算有多少对质数的和等于输入的这个正整数，并输出结果。输入值小于1000。
 * 如，输入为10, 程序应该输出结果为2。（共有两对质数的和为10,分别为(5,5),(3,7)）
 * 输入描述:
 */
public class 腾讯_素数对 {
    public static void main(String[] args) {
        // 质数（prime number）又称素数，有无限个。
        // 质数定义为在大于1的自然数中，除了1和它本身以外不再有其他因数。
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (cheak(i) && n - i > 1 && cheak(n - i)) {
                ans++;
            }
        }
        // 去掉重复的部分
        if (ans % 2 == 0) {
            System.out.println(ans / 2);
        } else {
            System.out.println(ans / 2 + 1);
        }
    }

    /**
     * 用于检查当前的数字是否是素数,是的返回true
     *
     * @param n
     * @return
     */
    public static boolean cheak(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
