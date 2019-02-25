package chapter05;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 给定的一个字符串str 的，判断是不是整体有效的括号字符串
 */
public class 括号字符串的有效性和最长有效长度 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//        boolean tmp = isValid1(str);
        int tmp = maxLenth(str);
        System.out.println("tmp=" + tmp);
    }

    public static boolean isValid(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        int left = 0;
        int right = 0;
        char[] chas = str.toCharArray();
        for (int i = 0; i < chas.length; i++) {
            if (right > left) {
                return false;
            }
            // 第一个就是右括号的除外
            if (chas[i] != ')' && chas[i] == '(') {
                left++;
            }
            if (chas[i] == ')') {
                right++;
            }
        }
        return left == right ? true : false;
    }

    // 书上的方式
    public static boolean isValid1(String str) {
        if (str == null && str.equals("")) {
            return false;
        }
        char[] chas = str.toCharArray();
        // status用来确定当前的括号是否是匹配的
        int status = 0;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != ')' && chas[i] == '(') {
                return false;
            }
            if (chas[i] == ')' && --status < 0) {
                return false;
            }
            if (chas[i] == '(') {
                status++;
            }
        }
        return status == 0;
    }


    /*
        补充题目，给定一个括号字符串str，返回最长的有效括号字串，就是返回最长的连续有效括号的长度
        使用动态规划进行解决，创建dp[str.length],dp[i]的值代表的是str[0....i]中必须以字符str[i]结尾的最长有效括号字串长度
        如果chas[i] == '(' 那么有效括号字串必须以‘）’结尾
        如果chas[i] == ')' 那么就有可能出现有最长有效括号子串
        pre = i - dp[i-1] - 1
        例如: ()(()())   i=6 chas[6] == ')' pre = 6 -2 -1
        在判断chas[pre] ?= '('
     */
    public static int maxLenth(String str) {
        if (str == null || str.equals("") ) {
            return 0;
        }
        char[] chas = str.toCharArray();
        int[] dp = new int[chas.length];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            if (chas[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chas[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + "\t");
        }
        return res;
    }
}
