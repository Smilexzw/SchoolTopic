package code;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: xuzhangwang
 */
public class 去掉字符串中的连续的ac和b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] c = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        // 直接使用栈进行的数据模拟，如果当前为c，判断栈顶是否为a，如果是就弹出栈顶元素，否则就加入
        for (char tmp : c) {
            if (tmp == 'b') {
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(tmp);
            } else {
                if (tmp == 'c' && stack.peek() == 'a') {
                    stack.pop();
                } else {
                    stack.push(tmp);
                }
            }
        }

        System.out.println(stack.toString());
    }
}
