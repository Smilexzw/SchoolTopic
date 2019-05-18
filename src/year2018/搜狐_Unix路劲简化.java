package year2018;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author: xuzhangwang
 */
public class 搜狐_Unix路劲简化 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split("/");
        // 遇到.. 之后会返回上级，如果不能就停留在当前页面
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("") || s[i].equals(".")) {
                continue;
            } else if (s[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s[i]);
            }
        }
        // 会出现为空的情况
        String res = "";
        for (int i = 0; i < stack.size(); i++) {
            res = res +  "/" + stack.get(i);
        }
        if (res == "") {
            System.out.println("/");
        } else {
            System.out.println(res);
        }
    }
}
