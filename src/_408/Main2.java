package _408;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        string = string.replaceAll("\\[", "");
        string = string.replaceAll("\\]", "");
        string = string.trim();
        String[] s = string.split(",");
        StringBuffer res = new StringBuffer();
        String str = "";
        int k = sc.nextInt();

        for (int i = 0; i < s.length; i++) {
            str += s[i];
        }


        for (int i = 0; i < s.length; i = i + k) {
            helper(s, k, i, res, str);
        }
        System.out.print("[");
        for (int i = 0; i < res.length(); i++) {
            if (i == res.length() - 1) {
                System.out.print(res.charAt(i) + "]");
            } else {
                System.out.print(res.charAt(i) + ",");
            }
        }
    }

    private static void helper(String[] s, int k, int start, StringBuffer res, String str) {
        if (start + k > s.length) {
            res.append(str.substring(start, str.length()));
        } else {
            String tmp = str.substring(start, start + k);
            StringBuffer sb = new StringBuffer(tmp);
            res.append(sb.reverse().toString());
        }
    }

}
