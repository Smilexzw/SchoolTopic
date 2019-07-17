package _702;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author xuzhangwang
 */
public class 万万没想到之聪明的编辑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n);
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            System.out.println(fun(s));
        }
    }

    /**
     * 返回想要的数据
     * @param str
     * @return
     */
    public static String fun(String str) {
        char[] c = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            list.add(c[i]);
        }
        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1) && list.get(i) == list.get(i - 2)) {
                list.remove(i);
                i--;
            }
        }
        for (int i = 3; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1) && list.get(i - 2) == list.get(i - 3)) {
                list.remove(i);
                i--;
            }
        }
        String res = "";
        for (Character character : list) {
            res += character;
        }
        return res;
    }
}
