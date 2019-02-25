package yearof2017;

import java.util.Scanner;

public class 网易_暗黑字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = refGetStrNum(n);
        System.out.println(num);
    }

    /**
     * 使用递归的版本求解暗黑字符串的个数
     * @Title: refGetStrNum
     * @Description:
     * @param @param n
     * @param @return    参数
     * @return int    返回类型
     * @throws
     */
    public static int refGetStrNum(int n) {
        // 求解暗黑字符串的个数
        if (n == 0) return 0;
        if (n == 1) return 3;
        if (n == 2) return 9;
        return 2 * refGetStrNum(n - 1) + refGetStrNum(n - 2);
    }
}
