package code;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 替换leetcode中的括号 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (sc.hasNextLine()) {
            s += sc.nextLine();
        }
        s = s.replaceAll("\\[", "{");
        s = s.replaceAll("\\]", "}");
        System.out.println(s);
    }
}
