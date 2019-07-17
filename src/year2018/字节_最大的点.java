package year2018;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author xuzhangwang
 */
public class 字节_最大的点 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Long, Long> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            map.put(sc.nextLong(), sc.nextLong());
        }

        int index = 0;
        long[] a = new long[n];
        long[] b = new long[n];
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            a[index] = entry.getKey();
            b[index] = entry.getValue();
            index++;
        }

        long maxY = b[n - 1];
        Map<Long, Long> res = new TreeMap<>();
        res.put(a[n - 1], b[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            if (b[i] > maxY ) {
                res.put(a[i], b[i]);
                maxY = b[i];
            }
        }

        for (Map.Entry<Long, Long> entry : res.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
