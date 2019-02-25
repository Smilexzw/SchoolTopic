package chapter05;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 新类型字符的定义如下
 * 1、新类型是长度为1或2的字符串
 * 2、表现形式是的可以仅仅是小写字母，也可以是小写+大写，也可以是大写+大写
 * 现在给定一个字符串str，str一定是若干个新字符类型的正确组合，给出k，返回新类型
 */
public class Chater05_pointNewchar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        String tmp = pointNewchar(str, k);
        System.out.println(tmp);
    }

    /*
        下面使用两种方法
        1、使用最笨的方法，从左到右依次的划分出的新字符类型，到k的位置就知道的指向新类型字符是什么
        2、更快的方法
            从k-1的位置开始，从左到右开始统计大写字母的数量记作uNum
            如果uNum为奇数，str[k-1...k]就是新的类型
            如果uNum为偶数，str[k]大写字母，str[k..k+1]是新的类型字符
                           str[k]小写字母，str[k]就是形的类型字符
     */
    public static String pointNewchar1(String str, int k) {
        if (str == null || str.equals("") || k < 0 || k >= str.length()) {
            return "";
        }
        char[] chas = str.toCharArray();
        String[] dp = new String[chas.length];
        for (int i = 0; i < chas.length; i++) {
            if (dp[i] == null && !Character.isLowerCase(chas[i])) {
                dp[i] = str.substring(i, i + 2);
                dp[i + 1] = dp[i];
            } else if (dp[i] == null){
                dp[i] = String.valueOf(chas[i]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + "\t");
        }
        return dp[k];
    }

    // 计算k-1开始之前的连续出现的大写字母
    public static String pointNewchar(String str, int k) {
        if (str == null || str.equals("") || k < 0 || k >= str.length()) {
            return "";
        }
        char[] chas = str.toCharArray();
        int uNum= 0;
        for (int i = k - 1; i >=0 ; i++) {
            if (Character.isLowerCase(chas[i])) {
                break;
            }
            uNum++;
        }
        System.out.println("uNUM=" + uNum);
        if ((uNum & 1) == 1) {
            return str.substring(k - 1, k + 1);
        }
        if (Character.isUpperCase(chas[k])) {
            return str.substring(k, k + 2);
        }
        return String.valueOf(chas[k]);
    }
}
