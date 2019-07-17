package code;

import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 替换双引号为单引号 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        while (sc.hasNextLine()) {
            s += sc.nextLine();
        }
        s = s.replaceAll("\"", "'");
        s = s.replaceAll("\"", "'");
        System.out.println(s);
    }
}
