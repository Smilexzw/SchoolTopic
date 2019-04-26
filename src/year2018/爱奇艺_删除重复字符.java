package year2018;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 爱奇艺_删除重复字符 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.nextLine().toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < c.length; i++) {
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            System.out.print(c[i]);
        }
    }
}
