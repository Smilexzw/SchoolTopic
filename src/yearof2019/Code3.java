package yearof2019;

import java.util.*;

/**
 * @Auther: xuzhangwang
 * @Description:
 */
public class Code3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            a.add(sc.nextInt());
        }

        for (int j = 0; j < n; j++) {
            b.add(sc.nextInt());
        }


        Collections.sort(a);
        Collections.sort(b);
        int x = 0;
        int y = 0;
        while (!a.isEmpty() || !b.isEmpty()) {

            // a做完
            if ((a.size() != 0 && b.size() != 0) &&a.get(a.size() - 1) > b.get(b.size() - 1)) {
                x += a.get(a.size() - 1);
                a.remove(a.size() - 1);
            } else if (b.size() != 0) {
                b.remove(b.size() - 1);
            }

            if ((b.size() != 0 && a.size() != 0) && b.get(b.size() - 1) > a.get(a.size() - 1)) {
                y += b.get(b.size() - 1);
                b.remove(b.size() - 1);
            } else if (a.size() != 0) {
                a.remove(a.size() - 1);
            }


        }
       if (x == y) {
           System.out.println(0);
       } else if (x > y) {
           System.out.println(x - y);
       } else {
           System.out.println(-1);
       }
    }
}
