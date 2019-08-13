package yearof2019;

import java.util.Scanner;

/**
 * 问题描述：
 * 人民币有很多不同面值的纸币，在本题中，只考虑以下 7 种面值的纸币，它们分别为：1 元、2 元、5 元、
 * 10 元、20 元、50 元、100 元。你知道凑出 n 元最少需要多少张纸币吗？
 * 输入描述:
 * 第一行输入一个数 T（1<=T<=10000），表示数据组数。接下来有 T 行，每行一个数 n（1<=n<=100000）。
 * 输出描述：
 * 每组数据输出一行，最少需要的纸币数。
 * 输入样例：
 * 5
 * 3
 * 4
 * 5
 * 9
 * 99
 * 输出样例：
 * 2
 * 2
 * 1
 * 3
 * 6
 * 样例解释：
 * 样例中第一行为 5，表示一共有 5 组数据。
 * 第一组数据为 3，答案为：1 张 1 元+1 张 2 元，一共 2 张纸币。
 * 第二组数据为 4，答案为：2 张 2 元，一共 2 张纸币。
 * 第三组数据为 5，答案为：1 张 5 元，一共 1 张纸币。
 * 第四组数据为 9，答案为：2 张 2 元+1 张 5 元，一共 3 张纸币。
 * 第五组数据为 99，答案为：2 张 2 元+1 张 5 元+2 张 20 元+1 张 50 元，一共 6 张纸币。
 *
 * @author xuzhangwang
 */
public class 贝壳找房_钱币问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            int res = helper(number);
            System.out.println(res);
        }
    }

    private static int helper(int money) {
        int count = 0;
        if (money >= 100) {
            count += (money / 100);
            money %= 100;
        }
        if (money >= 50) {
            count += (money / 50);
            money %= 50;
        }
        if (money >= 20) {
            count += (money / 20);
            money %= 20;
        }
        if (money >= 10) {
            count += (money / 10);
            money %= 10;
        }
        if (money >= 5) {
            count += (money / 5);
            money %= 5;
        }
        if (money >= 2) {
            count += (money / 2);
            money %= 2;
        }
        count += money;
        return count;
    }
}
