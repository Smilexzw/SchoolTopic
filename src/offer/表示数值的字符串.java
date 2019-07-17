package offer;

import java.util.Scanner;

/**
 * @author xuzhangwang
 */
public class 表示数值的字符串 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean res = isNumeric(str.toCharArray());
        System.out.println(res);
    }

    /**
     * 使用正则表示式子
     * [] ： 字符集合
     * () : 分组
     * ?  : 重复0~1次
     * +  : 重复1~n次
     * *  : 重复0~n次
     * .  : 任意字符
     *\\. : 转义之后的 .
     * \\d ： 数字
     * @param str
     * @return
     */
    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) return false;
        String match = "[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?";
        return new String(str).matches(match);
    }
}
