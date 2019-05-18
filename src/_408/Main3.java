package _408;

import java.util.*;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = sc.next().split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        map.put(s[0], 0);
        for (int i = 0; i < s.length; i++) {
                helper(s[i], res);
        }


        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
        }
    }

    private static void helper2(String s, List<String> res) {
        String t = "";

    }

    private static void helper(String s, List<String> res) {
        String t = "";
        for (int j = 0; j < s.length(); j++) {
            if (!(s.toLowerCase().charAt(j) >= 'a' && s.toLowerCase().charAt(j) <= 'z')) {
                t += "1";
            }
        }
        res.add(t);
    }
}
