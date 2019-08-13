package yearof2019;

import java.util.*;

/**
 *
 * 对于一个非负整数我们称它是美丽的当且仅当它的十进制表示下不包含多个相同的数字。比如 1234，7523
 都是美丽的，但 99，121，3043 等都不是美丽的。现在给出一个数字n，你需要找到比n大的，最小的美
 丽的数。
 输入描述：
 第一行包含一个整数n。1000 ≤ n ≤ 9000
 输出描述：
 输出对应的答案，若不存在满足条件的数，输出-1。
 输入样例 1：
 1987
 输出样例 1：
 2013
 输入样例 2：
 2013
 输出样例 2：
 2014
 * @author xuzhangwang
 */
public class 贝壳找房_美丽的数 {

    static Stack<Integer> stack;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = n; i <= 9000; i++) {
            int number = i;
            valid(number);
        }

        if (list.contains(n)) {
            list.remove(0);
        }
        if (list.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(0));
        }

    }

    private static void valid(int number) {
        int t = number;
        stack = new Stack<>();
        while (number != 0) {
            int mod = number % 10;
            if (stack.contains(mod)) {
                return;
            }
            stack.add(number % 10);
            number /= 10;
        }
        list.add(t);
    }
}
