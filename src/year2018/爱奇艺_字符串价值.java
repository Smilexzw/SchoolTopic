package year2018;

import java.util.*;

/**
 * @author: xuzhangwang
 */
public class 爱奇艺_字符串价值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.nextLine().toCharArray();
        int k = sc.nextInt();

        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                map.put(c[i], map.get(c[i])+ 1);
            } else {
                map.put(c[i], 1);
            }
        }
        List<Integer> list = new ArrayList<>(map.values());
        int[] p = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            p[i] = list.get(i);
        }
        int res = 0;
        while (k != 0) {
            Arrays.sort(p);
            p[p.length - 1]--;
            k--;
        }
        for (int i = 0; i < p.length; i++) {
            if (p[i] == 0) continue;
            res += (p[i] * p[i]);
        }
        System.out.println(res);
    }
}
