package leetcode;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author xuzhangwang
 * @date 2019/7/30
 */
public class _071Unix简化路劲 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String res = simplifyPath(str);
        System.out.println(res);
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        System.out.println(Arrays.toString(split));
        for (String s : split) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.equals(".") && !s.equals("")) {
                stack.push(s);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }

        if (res.length() == 0) {
            return "/";
        }
        return res;
    }
}
