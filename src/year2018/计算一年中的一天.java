package year2018;

import java.util.Scanner;

/**
 * 题目描述
 * 今年的第几天？
 * <p>
 * 输入年、月、日，计算该天是本年的第几天。
 * <p>
 * 输入描述:
 * 包括三个整数年(1<=Y<=3000)、月(1<=M<=12)、日(1<=D<=31)。
 * 输出描述:
 * 输入可能有多组测试数据，对于每一组测试数据，
 * 输出一个整数，代表Input中的年、月、日对应本年的第几天。
 * 示例1
 * 输入
 * 复制
 * 1990 9 20
 * 2000 5 1
 * 输出
 * 复制
 * 263
 * 122
 *
 * @author: xuzhangwang
 */
public class 计算一年中的一天 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (sc.hasNextInt()) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int ans = 0;
            // 判断是否是闰年, 闰年的二月为29天
            if (isLeapYear(year)) {
                ans = getDay(month, day, true);
            } else {
                ans = getDay(month, day, false);
            }
            System.out.println(ans);
        }

    }

    /**
     * 获取天数
     * @param month
     * @param day
     */
    private static int getDay(int month, int day, boolean flag) {
        int res = 0;
        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                res += 31;
            }
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                res += 30;
            }
            if (i ==  2) {
                if (flag) {
                    res += 29;
                } else {
                    res += 28;
                }
            }
        }
        res += day;

        return res;
    }

    private static boolean isLeapYear(int year) {
        // 能被400整除， 能被4整除但是不能被100整除
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }
}
