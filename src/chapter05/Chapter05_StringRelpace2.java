package chapter05;

import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 字符串的调整和替换，补充题目
 * 给定一个字符类型的chas[],其中只含有数字字符和"*"字符，现在想要把所有的"*"字符挪到的chas的左边，数字字符挪到chas的右边
 * 例如 “12**345” 要转变成"**12345"
 */
public class Chapter05_StringRelpace2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chas = str.toCharArray();
        relpace(chas);
        System.out.println(String.valueOf(chas));
    }

    public static void relpace(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        int num = 0;
        int len = chas.length;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] == '*') {
                num++;
            }
        }
        len--;
        for (int j = chas.length - 1; j > 0 ; j--) {
            if (chas[j] != '*') {
                chas[len--] = chas[j];
            }
        }
        for (int i = 0; i < num - 1; i++) {
            chas[i] = '*';
        }
    }

    public static void relpace2(char[] chas) {
        if (chas == null || chas.length == 0) {
            return;
        }
        int j = chas.length - 1;
        for (int i = chas.length - 1; i > -1; i--) {
            if (chas[i] != '*') {
                chas[j--] = chas[i];
            }
        }
        for (; j > -1 ;) {
            chas[j--] = '*';
        }

    }
}
