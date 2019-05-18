package year2018;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: xuzhangwang
 */
public class 爱奇艺_缺失的括号 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] c = sc.nextLine().toCharArray();

        // 使用栈进行数据的匹配

        Stack<Character> stack = new Stack<>();
        if (c.length == 0) {
            System.out.println(0);
        } else {
            for (int i = 0; i < c.length; i++) {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(' && c[i] == ')') {
                        stack.pop();
                    } else {
                        stack.push(c[i]);
                    }
                } else {
                    stack.push(c[i]);
                }
            }
        }

        System.out.println(stack.size());

    }
}
