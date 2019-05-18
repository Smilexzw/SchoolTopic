package yearof2017;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Auther: xuzhangwang
 * @Description: 题目描述
 * 酒店房间的价格录入是通过时间段来录入的，比如10月1日至10月7日800元，10月8日至10月20日500元，
 * 请实现以下函数int[][] merge(int[][] dateRangePrices)，
 * 输入是某个酒店多个日期段的价格，每个日期段（终止日期大于等于起始日期）和对应的价格使用长度为3的数组来表示，
 * 比如[0, 19, 300], [10, 40, 250]分别表示从某天开始第1天到第20天价格都是300，第11天到第41天价格都是250，
 * 这些日期端有可能重复，重复的日期的价格以后面的为准， 请以以下规则合并并输出合并结果：
 * 1.相邻两天的价格如果相同，那么这两个日期段应该合并
 * 2.合并的结果应该以起始日期从小到大排序
 * 输入描述:
 * 输入数据包括多行，如样例输入所示。
 * 输出描述:
 * 输出数据为一行，如样例输出所示
 * 示例1
 * 输入
 * 复制
 * 1 1 100
 * 2 3 100
 * 4 5 110
 * 输出
 * 复制
 * [1, 3, 100],[4, 5, 110]
 */
public class 去哪儿_酒店价格 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> map = new HashMap<>();
//        while(sc.hasNext()) {
//            int start = sc.nextInt();
//            int end = sc.nextInt();
//            int price = sc.nextInt();
//            map.put(price, "[" + start + "," + end + "]");
//        }
        map.put(100, "[" + 1 + "," + 1 + "]");
        map.put(100, "[" + 2 + "," + 3 + "]");
        map.put(110, "[" + 4 + "," + 5 + "]");
        for (Integer integer : map.keySet()) {
            System.out.print(integer + "\t" + map.get(integer) + "\n");
        }

    }
}
