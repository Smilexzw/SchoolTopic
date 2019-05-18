package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: xuzhangwang
 */
public class 字符串全排列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> res = Permutation(str);
        System.out.println(res.toString());
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str == "") {
            return res;
        }

        char[] c = str.toCharArray();
        Arrays.sort(c);
        helper(res, c, new ArrayList<Character>(), new boolean[c.length]);
        return res;
    }

    private static void helper(ArrayList<String> res, char[] c, ArrayList<Character> list, boolean[] used) {
        if (list.size() == c.length) {
            String tmp = "";
            for (int i = 0; i < list.size(); i++) {
                tmp += list.get(i);
            }
            res.add(tmp);
            return;
        }

        for (int i = 0; i < c.length; i++) {
            if (used[i] || i > 0 && c[i] == c[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            list.add(c[i]);
            helper(res, c, list, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
