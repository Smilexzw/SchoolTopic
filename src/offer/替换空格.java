package offer;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class 替换空格 {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We Are Happy");
        String res = replaceSpace(sb);
        System.out.println(res);
    }
    public static String replaceSpace(StringBuffer str) {
        String s = str.toString();
        s = s.replaceAll(" ", "%20");
        return s;
    }
}
