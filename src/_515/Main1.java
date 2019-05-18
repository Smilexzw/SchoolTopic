package _515;

import java.util.*;

/**
 * @author: xuzhangwang
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[3];
        int[] b = new int[3];
        int res_a = 0;
        int res_b = 0;
        for (int i = 0; i < 3; i++) {
            a[i] = sc.nextInt();
            res_a += a[i];
        }
        for (int i = 0; i < 3; i++) {
            b[i] = sc.nextInt();
            res_b += b[i];
        }

        double fenwu = 2070;

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            list.add(i + 1);
            list.add(i + 1);
            list.add(i + 1);
            list.add(i + 1);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == a[i]) {
                    list.remove(j);
                    break;
                }
            }
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == b[i]) {
                    list.remove(j);
                    break;
                }
            }
        }

        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            tmp.add(list.get(i));
        }
        for (int i = 0; i < tmp.size(); i++) {
            int ta = res_a;
            ta += tmp.get(i);
            tmp.remove(i);
            for (int j = 0; j < tmp.size(); j++) {
                int tb = res_b;
                if ((tb + tmp.get(j)) < ta) {
                    count++;
                }
            }
            tmp.add(list.get(i));
            Collections.sort(tmp);
        }

        double d = count / fenwu;
        System.out.println(String.format("%.4f", d));
    }
}
