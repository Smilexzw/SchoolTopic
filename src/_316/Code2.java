package _316;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class Code2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        syso(str.toCharArray());
    }

    public static void syso(char[] chars) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
        }
        for (int i = 1; i < list.size(); ) {
            if (i == list.size() - 1) break;
            if (list.get(i) != list.get(i - 1)) {
                i++;
                continue;
            }
            int cur = i + 1;
            if (cur < list.size() && list.get(cur) == list.get(i)) {
                while (list.get(i) == list.get(cur) && cur + 1 < list.size()) {
                    list.remove(cur);
                }
                i = cur;
            } else if (cur < list.size() && list.get(cur) != list.get(i)) {
                while (list.get(cur) == list.get(cur + 1) && cur + 1 < list.size()) {
                    list.remove(cur);
                }
                i = cur;
            }

        }
        System.out.println(list.toString());
    }
}