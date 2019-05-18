package year2018;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * @Auther: xuzhangwang
 * @Description: P为给定的二维平面整数点集。
 * 定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。
 * 求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
 * <p>
 * 如下图：实心点为满足条件的点的集合。请实现代码找到集合 P 中的所有 ”最大“ 点的集合并输出。
 */
public class 头条_编程题1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(new BufferedInputStream(System.in));
//        int N = sc.nextInt();
//        Map<String, String> map = new TreeMap<>();
//        for (int i = 0; i < N; i++) {
//            String x = sc.next();
//            String y = sc.next();
//            map.put(x, y);
//        }
//        sc.close();
//        // 所有的点的x和y的坐标都不重复的
//        List<String> xList = new ArrayList<>();
//        List<String> yList = new ArrayList<>();
//
//
//
//        Iterator it = map.entrySet().iterator() ;
//        while(it.hasNext()) {
//            Map.Entry entry = (Map.Entry) it.next() ;
//            xList.add((String) entry.getKey());
//            yList.add((String) entry.getValue());
//        }
//
//
//
//        Map<String, String> result = new TreeMap<>();
//
//        Long max = Long.MIN_VALUE;
//        for (int i = xList.size() - 1; i >= 0; i--) {
//            max = Math.max(Long.valueOf(yList.get(i)), max);
//            if (max.equals(Long.valueOf(yList.get(i)))) {
//                result.put(xList.get(i), yList.get(i));
//            }
//        }
//
//
//        Iterator res = result.entrySet().iterator() ;
//        while(res.hasNext()) {
//            Map.Entry entry = (Map.Entry) res.next() ;
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] m = new long[2][n];
        for (int i = 0; i < n; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            m[0][i] = x;
            m[1][i] = y;
        }
        int len = m[0].length;
        long max = m[1][len - 1];
        Map<Long, Long> map = new TreeMap<>();
        for (int i = m[0].length - 1; i > 0; i--) {
            if (m[1][i] < max) continue;
            max = m[1][i];
            map.put(max = m[0][i], max = m[1][i]);
        }

        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
