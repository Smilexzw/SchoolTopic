package yearof2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 尽管是一个CS专业的学生，小B的数学基础很好并对数值计算有着特别的兴趣，喜欢用计算机程序来解决数学问题，
 * 现在，她正在玩一个数值变换的游戏。她发现计算机中经常用不同的进制表示一个数，如十进制数123表达为16进制时只包含两位数7、11（B），
 * 用八进制表示为三位数1、7、3，按不同进制表达时，各个位数的和也不同，如上述例子中十六进制和八进制中各位数的和分别是18和11,。
 * 小B感兴趣的是，一个数A如果按2到A-1进制表达时，各个位数之和的均值是多少？她希望你能帮她解决这个问题？ 所有的计算均基于十进制进行，
 * 结果也用十进制表示为不可约简的分数形式。
 */
public class 京东_进制均值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            toOtherDecimal(sc.nextInt());
        }
    }

    /**
     * 把当前的数转换成为其他进制的转换
     * @param n
     */
    private static void toOtherDecimal(int n) {
        int fenzi = 0;
        for (int i = 2; i < n; i++) {
            int tmp = n;
            while (tmp != 0) {
                fenzi += tmp % i;
                tmp /= i;
            }
        }
        int fenmu = n - 2;
        int gcd = gcd(fenzi, fenmu);
        fenzi /= gcd;
        fenmu /= gcd;
        System.out.println(fenzi + "/" + fenmu);
    }

    /**
     * 欧几里得算法求两个数的最大公约数
     * @param m
     * @param n
     * @return
     */
    public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
