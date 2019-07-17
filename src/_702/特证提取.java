package _702;


import java.util.*;

/**
 * @author xuzhangwang
 */
public class 特证提取 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            System.out.println(fun(M));
        }
    }

    private static int fun(int m) {
        Set<String> set =  new HashSet<>();
        for (int i = 0; i < m; i++) {
            String tmp = "";
            int key = sc.nextInt();
            if (key == 0) continue;
            for (int j = 0; j < 2 * key; j++) {
                tmp += sc.next();
            }
            set.add(tmp);
        }

        List<String> list = new ArrayList<>();
        for (String s : set) {
            if (s.length() == 2) {
               list.add(s);
            } else {
                for (int i = 0; i < s.length(); i+=2) {
                    list.add(s.substring(i, i + 2));
                }
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        int max = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        return max;
    }
}
