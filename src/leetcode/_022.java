package leetcode;

import java.util.*;

/**
 * @Auther: xuzhangwang
 * @Description:22. 括号生成
 * 题目描述
 * 评论 (177)
 * 题解
 * 提交记录
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * <p>
 * 使用dfs生成在验证括号是否正确
 */
public class _022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> list = generateParenthesis(n);
        System.out.println(list.toString());
    }

    /**
     * 使用回溯
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, "", n, n);
        return res;
    }

    private static void helper(List<String> res, String s, int left, int right) {
        if (left > right) return;
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            helper(res, s + "(", left - 1, right);
        }
        if (right > 0) {
            helper(res, s +")", left, right - 1);
        }
    }


    /*
        效率太低了
     */

//    public static List<String> generateParenthesis(int n) {
//        if (n == 0) return new ArrayList<String>();
//        List<String> list = new ArrayList<>();
//        Set<String> set = new HashSet<>();
//        s(n, list, set);
//
//        return list;
//    }
//
//    private static void s(int n, List<String> list, Set<String> set) {
//        String[] s = new String[2 * n];
//        for (int i = 0; i < n; i++) {
//            s[i] = "(";
//        }
//        for (int i = 2 * n - 1; i >= n; i--) {
//            s[i] = ")";
//        }
//        dfs(s, 0, list, set);
//    }
//
//    private static void dfs(String[] s, int k, List<String> list, Set<String> set) {
//        if (k == s.length) {
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < s.length; i++) {
//                sb.append(s[i]);
//            }
//            if (!set.contains(sb.toString())) {
//                list.add(sb.toString());
//                set.add(sb.toString());
//            }
//        }
//
//        if (valid(s, k)) {
//            for (int i = k; i < s.length; i++) {
//                String t = s[i];
//                s[i] = s[k];
//                s[k] = t;
//
//                dfs(s, k + 1, list, set);
//
//                t = s[i];
//                s[i] = s[k];
//                s[k] = t;
//            }
//        }
//    }
//
//    private static boolean valid(String[] s, int k) {
//        if (s == null || s.length == 0) return true;
//        Stack<String> stack = new Stack<>();
//        for (int i = 0; i <= k; i++) {
//            if (s[i] == "(") {
//                stack.push(")");
//            } else {
//                if (stack.isEmpty() || stack.pop() != s[i]) return false;
//            }
//        }
//
//        return stack.isEmpty();
//    }

}
